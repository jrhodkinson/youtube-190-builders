package youtube.builders.level3;

import java.util.Collections;
import java.util.List;

// Level 3: required fields
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

    public static Builder builder(String firstName, String lastName)
    {
        return new Builder(firstName, lastName);
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
        private final String firstName;
        private List<String> middleNames = Collections.emptyList();
        private final String lastName;
        private String email;
        private String phone;

        public Builder(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleNames(List<String> middleNames)
        {
            this.middleNames = middleNames;
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
            return new Person(this);
        }
    }
}
