package youtube.builders.sorcery2;

import java.util.Collections;
import java.util.List;

// Dark arts level 2, interface chaining with multiple paths
// Either: firstName then lastName, then anything
// Or: email, then anything
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

    public static FirstNameOrEmailSetter builder()
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

    public interface FirstNameOrEmailSetter
    {
        LastNameSetter firstName(String firstName);

        NameOrOptionalFieldsSetter email(String email);
    }

    public interface LastNameSetter
    {
        EmailOrOptionalFieldsSetter lastName(String lastName);
    }

    public interface EmailOrOptionalFieldsSetter extends OptionalFieldsSetter
    {
        OptionalFieldsSetter email(String email);
    }

    public interface NameOrOptionalFieldsSetter extends OptionalFieldsSetter
    {
        LastNameThenOptionalFieldsSetter firstName(String firstName);
    }

    public interface LastNameThenOptionalFieldsSetter
    {
        OptionalFieldsSetter lastName(String lastName);
    }

    public interface OptionalFieldsSetter
    {
        OptionalFieldsSetter middleNames(List<String> middleNames);

        OptionalFieldsSetter phone(String phone);

        Person build();
    }

    private static class Builder implements FirstNameOrEmailSetter, LastNameSetter, EmailOrOptionalFieldsSetter, NameOrOptionalFieldsSetter, LastNameThenOptionalFieldsSetter, OptionalFieldsSetter
    {
        private String firstName;
        private List<String> middleNames = Collections.emptyList();
        private String lastName;
        private String email;
        private String phone;

        @Override
        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        @Override
        public Builder middleNames(List<String> middleNames)
        {
            this.middleNames = middleNames;
            return this;
        }

        @Override
        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        @Override
        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        @Override
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
