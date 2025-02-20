package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldCreateValidPerson() {
        Person person = Person.builder()
                .id("117")
                .firstName("Rahul")
                .lastName("Tripathi")
                .age(32)
                .gender("Male")
                .build();

        assertNotNull(person);
        assertEquals("Rahul", person.getFirstName());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .firstName("Rahul")
                    .lastName("Tripathi")
                    .age(32)
                    .gender("Male")
                    .build();
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }
}
