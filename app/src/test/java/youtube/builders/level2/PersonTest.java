package youtube.builders.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest
{
    @Test
    void canCreateValidPersonWithBuilder()
    {
        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("555-555-5555")
                .build();

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(person.getMiddleNames()).isEmpty();
        assertThat(person.getLastName()).isEqualTo("Doe");
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isEqualTo("555-555-5555");
    }

    @Test
    void cannotCreatePersonWithoutFirstName()
    {
        Person.Builder builder = Person.builder()
                .phone("555-555-5555");

        assertThatThrownBy(builder::build)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("firstName is required");
    }

    @Test
    void cannotCreatePersonWithoutLastName()
    {
        Person.Builder builder = Person.builder()
                .firstName("John")
                .phone("555-555-5555");

        assertThatThrownBy(builder::build)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("lastName is required");
    }
}