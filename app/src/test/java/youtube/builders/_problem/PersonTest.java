package youtube.builders._problem;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest
{
    @Test
    void canCreatePersonWithJustFirstAndLastName()
    {
        Person person = new Person("John", "Doe");

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getMiddleNames()).isEmpty();
        assertThat(person.getLastName()).isEqualTo("Doe");
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isNull();
    }

    @Test
    void passingPhoneIntoEmailFieldDoesNotThrowException()
    {
        Person person = new Person("John", "Doe", "555-555-5555"); // oops, wrong constructor

        assertThat(person.getEmail()).isEqualTo("555-555-5555");
        assertThat(person.getPhone()).isNull();
    }

    @Test
    void canCreatePersonWithFirstAndLastNameAndPhone()
    {
        Person person = new Person("John", "Doe", null, "555-555-5555");

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getMiddleNames()).isEmpty();
        assertThat(person.getLastName()).isEqualTo("Doe");
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isEqualTo("555-555-5555");
    }

    @Test
    void canCreatePersonWithFirstMiddleAndLastNames()
    {
        Person person = new Person("John", Collections.singletonList("Jacob"), "Jingleheimer-Schmidt", null, null);

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getMiddleNames()).containsExactly("Jacob");
        assertThat(person.getLastName()).isEqualTo("Jingleheimer-Schmidt");
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isNull();
    }
}