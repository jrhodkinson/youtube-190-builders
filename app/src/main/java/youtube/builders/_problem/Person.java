package youtube.builders._problem;

import java.util.Collections;
import java.util.List;

public class Person
{
    private final String firstName;
    private final List<String> middleNames;
    private final String lastName;
    private final String email; // Optional
    private final String phone; // Optional

    public Person(String firstName, List<String> middleNames, String lastName, String email, String phone)
    {
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Person(String firstName, String lastName)
    {
        this(firstName, Collections.emptyList(), lastName, null, null);
    }

    public Person(String firstName, String lastName, String email)
    {
        this(firstName, Collections.emptyList(), lastName, email, null);
    }

    public Person(String firstName, String lastName, String email, String phone)
    {
        this(firstName, Collections.emptyList(), lastName, email, phone);
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
}