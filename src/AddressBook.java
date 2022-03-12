import java.util.LinkedList;

/**
 * An address book contains lots of contact
 * @author Li Yixiao
 * @version 1.0
 */
public class AddressBook {
    BinarySearchTree<Contact,Key> tree;

    /**
     * Constructs a default address book
     */
    public AddressBook(){
        this.tree=new BinarySearchTree<>();
    }

    /**
     * Constructs a address book with one contact
     * @param root The binary tree's root that hold the contact
     */
    public  AddressBook(TreeNode<Contact,Key> root){
        this.tree=new BinarySearchTree<>(root);
    }

    /**
     * Search the contact in the address book
     * @param name The contact that need to be searched
     * @return A reference of the contact that needed to be searched
     */
    public TreeNode<Contact,Key> search (String name){
        return this.tree.search(new Key(name));
    }

    /**
     * Insert a new contact to the address book
     * @param contact The contact that needed to be inserted
     */
    public void insert (Contact contact){
        this.tree.insert(new TreeNode<Contact,Key>(contact,contact.getKey()));
    }

    /**
     * Delete a contact in the address book
     * @param name The name of the contact that needed to be deleted
     */
    public void delete(String name){
        this.tree.delete(new Key(name));
    }

    /**
     * Check if the address book is empty
     * @return A boolean value
     */
    public boolean isEmpty(){
        return this.tree.isEmpty();
    }

    /**
     * Make the address book empty
     */
    public void makeEmpty(){
        this.tree.makeEmpty();
    }

    /**
     * Get the tree of the address book
     * @return A reference of the address book
     */
    public BinarySearchTree<Contact,Key> getTree(){
        return this.tree;
    }

    /**
     * Search the contact with the same zipcode
     * @param zipCode The zipcode that needed to be searched
     * @return A linked list that holds the contact
     */
    public LinkedList<Contact> searchSameZipCode(String zipCode){
        TreeIterator<Contact,Key> iterator=new TreeIterator<>(this.tree);
        iterator.setInorder();
        LinkedList<Contact> sameZipCode=new LinkedList<>();
        while(iterator.hasNext()){
            Contact contact=iterator.next();
            if(contact.getAddress().getZipcode().equals(zipCode))
                sameZipCode.add(contact);
        }
        for (Contact contact:sameZipCode){
            System.out.println(contact.toString());
        }
        return sameZipCode;
    }

    /**
     * Search the contact with the same city
     * @param city The city that needed to be searched
     * @return A linked list that holds the contact
     */
    public LinkedList<Contact> searchSameCity(String city){
        TreeIterator<Contact,Key> iterator=new TreeIterator<>(this.tree);
        iterator.setInorder();
        LinkedList<Contact> sameCity=new LinkedList<>();
        while(iterator.hasNext()){
            Contact contact=iterator.next();
            if(contact.getAddress().getCity().equals(city))
                sameCity.add(contact);
        }
        for (Contact contact:sameCity){
            System.out.println(contact.toString());
        }
        return sameCity;
    }

    /**
     * Search the contact with the same phone number
     * @param Number The phone number that needed to be searched
     * @return A linked list that holds the contact
     */
    public LinkedList<Contact> searchPhoneNumber(String Number){
        TreeIterator<Contact,Key> iterator=new TreeIterator<>(this.tree);
        iterator.setInorder();
        LinkedList<Contact> sameNumber=new LinkedList<>();
        while(iterator.hasNext()){
            Contact contact=iterator.next();
            if(contact.getPhone().equals(Number))
                sameNumber.add(contact);
        }
        for (Contact contact:sameNumber){
            System.out.println(contact.toString());
        }
        return sameNumber;
    }
}

