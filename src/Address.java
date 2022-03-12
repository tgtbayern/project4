/**
 * An address of a contact
 * @author Li Yixiao
 * @version 1.0
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;

    /**
     * Constructs the address of the contact
     * @param street A reference to the street of this contact
     * @param city A reference to the city of this contact
     * @param state A reference to the state of this contact
     * @param zipcode A reference to the zipcode of this contact
     */
    public Address(String street,String city,String state,String zipcode){
        this.city=city;
        this.state=state;
        this.street=street;
        this.zipcode=zipcode;
    }

    /**
     * Get the city of the contact
     * @return A reference to the city of this contact
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the state of the contact
     * @return A reference to the state of this contact
     */
    public String getState() {
        return state;
    }

    /**
     * Get the street of the contact
     * @return A reference to the street of this contact
     */
    public String getStreet() {
        return street;
    }

    /**
     * Get the zipcode of the contact
     * @return A reference to the zipcode of this contact
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Convert the address to a string
     * @return A string to the whole address of this contact
     */
    public String toString(){
        String information=" State: "+this.state+" City: "+this.city+
                " Street: "+this.street+" Zipcode: "+this.zipcode;
        return information;
    }
}
