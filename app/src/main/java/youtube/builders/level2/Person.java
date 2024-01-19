package youtube.builders.level2;

import java.util.Collections;
import java.util.List;

// Level 2: validation
public class Person
{
    private final String firstName;
    private final List<String> middleNames;
    private final String lastName;
    private final String email;
    private final String phone;

    private Person(Builder builder)
    {
        this.firstName = builder.firstName;
        this.middleNames = builder.middleNames;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public String getFirstName()
    {
        return firstName;
    }

    public List<String> getMiddleNames()
    {
        return middleNames;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public static class Builder
    {
        private String firstName;
        private List<String> middleNames = Collections.emptyList();
        private String lastName;
        private String email;
        private String phone;

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder middleNames(List<String> middleNames)
        {
            this.middleNames = middleNames;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        public Builder phone(String phone)
        {
            this.phone = phone;
            return this;
        }

        public Person build()
        {
            if (firstName == null) {
                throw new IllegalStateException("firstName is required");
            }

            if (lastName == null) {
                throw new IllegalStateException("lastName is required");
            }

            return new Person(this);
        }
    }
}
