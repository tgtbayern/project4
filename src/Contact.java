/**
 * An contact in the address book
 * @author Li Yixiao
 * @version 1.0
 */
public class Contact {
    private String first_name;
    private String Last_name;
    private Address address;
    private String phone;

    /**
     * Constructs a contact
     * @param first_name First name of the contact
     * @param Last_name Last name of the contact
     * @param address address of the contact
     * @param phone phone of the contact
     */
    public Contact(String first_name,String Last_name,Address address,String phone){
        this.first_name=first_name;
        this.Last_name=Last_name;
        this.address=address;
        this.phone=phone;
    }

    /**
     * Get the key of the contact
     * @return The key of the contact
     */
   public Key getKey(){
        String fullName=this.first_name+this.Last_name;
        Key key=new Key(fullName);
        return key;
   }

    /**
     * Get the address of the contact
     * @return The address of the contact
     */
   public Address getAddress(){
        return this.address;
   }

    /**
     * Get the phone of the contact
     * @return The phone of the contact
     */
   public String getPhone(){
        return this.phone.substring(0, 3);
   }

    /**
     * Convert the information of the contact to string
     * @return A string of the contact information
     */
   public String toString(){
        String information="First_name: "+this.first_name+
                " Last name: "+this.Last_name+this.address.toString()+" Phone: "+this.phone;
        return information;
   }
}
