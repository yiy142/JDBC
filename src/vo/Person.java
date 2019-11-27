package vo;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int newPersonId){
        this.personId = newPersonId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public String toString() {
        return "Person [id=" + this.personId + ", FirstName=" + this.firstName + ", LastName=" + this.lastName + "]";
    }
}
