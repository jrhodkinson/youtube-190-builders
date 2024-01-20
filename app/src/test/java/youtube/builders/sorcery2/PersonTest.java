package youtube.builders.sorcery2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest
{
    @Test
    void canCreatePersonWithFirstNameAndLastName()
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
    void canCreatePersonWithEmail()
    {
        Person person = Person.builder()
                .email("john.doe@example.com")
                .build();

        assertThat(person.getFirstName()).isNull();
        assertThat(person.getMiddleNames()).isEmpty();
        assertThat(person.getLastName()).isNull();
        assertThat(person.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(person.getPhone()).isNull();
    }

//    @Test
//    void cannotCreatePersonWithoutFirstName()
//    {
//        Person person = Person.builder()
//                .phone("555-555-5555") // doesn't compile
//                .build();
//    }
}