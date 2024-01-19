package youtube.builders.level0;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest
{
    @Test
    void canCreatePersonWithFirstAndLastNameAndPhone()
    {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setPhone("555-555-5555");

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getMiddleName()).isNull();
        assertThat(person.getLastName()).isEqualTo("Doe");
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isEqualTo("555-555-5555");
    }

    @Test
    void canCreateInvalidPerson()
    {
        Person person = new Person();

        assertThat(person.getFirstName()).isNull(); // should be required!
        assertThat(person.getMiddleName()).isNull(); // should be required!
        assertThat(person.getLastName()).isNull();
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isNull();
    }

    @Test
    void canMutatePerson()
    {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getLastName()).isEqualTo("Doe");

        person.setFirstName("Jane");
        person.setLastName("Smith");

        assertThat(person.getFirstName()).isEqualTo("Jane");
        assertThat(person.getLastName()).isEqualTo("Smith");
    }
}