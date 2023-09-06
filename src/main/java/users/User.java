package users;

public class User {
    private static int uuid = 1000;

    private String firstName;
    private String lastName;
    private final int  id;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        uuid++;
        this.id = uuid;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
