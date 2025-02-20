package org.example;

// import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
// @JsonDeserialize(builder = Person.PersonBuilder.class)
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

    // Validate input in builder
    public static class PersonBuilder {
        public Person build() {
            if (id == null) throw new IllegalArgumentException("ID cannot be null");
            if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name cannot be null or blank");
            if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name cannot be null or blank");
            if (age != null && age < 0) throw new IllegalArgumentException("Age cannot be negative");
            return new Person(id, firstName, lastName, age, gender);
        }
    }
}
