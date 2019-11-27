package vo;

public class Address {
    private int personId;
    private int addressId;
    private String city;
    private String state;


    public String getCity() {
        return city;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

    public String getState() {
        return state;
    }

    public void setState(String newState) {
        this.state = newState;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int newPersonId){
        this.personId = newPersonId;
    }

    public int getAddressId(){
        return addressId;
    }

    public void setAddressId(int newAddressId){
        this.addressId = newAddressId;
    }

    public String toString() {
        return "Address [AddressId=" + this.addressId + ", PersonId=" + this.personId + ", City=" + this.city + ", State="
                + this.state + "]";
    }
}
