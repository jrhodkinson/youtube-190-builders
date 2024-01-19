package youtube.builders.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest
{
    @Test
    void canCreatePersonWithBuilder()
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
    void canCreatePersonWithoutName()
    {
        Person person = Person.builder()
                .phone("555-555-5555")
                .build();

        assertThat(person.getFirstName()).isNull(); // Should be required
        assertThat(person.getMiddleNames()).isEmpty();
        assertThat(person.getLastName()).isNull(); // Should be required
        assertThat(person.getEmail()).isNull();
        assertThat(person.getPhone()).isEqualTo("555-555-5555");
    }
}