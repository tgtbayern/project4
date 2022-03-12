import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The helper class of the programme
 * @author Li Yixiao
 * @version 1.0
 */
public class Helper {
    /**
     * Start method of the programme
     */
    public static void start(){
        AddressBook list=new AddressBook();
        create(list);
        System.out.println("This is the original tree:");
        display(list);
        System.out.println();
        System.out.println("Search Abel Maclead");
        System.out.println(list.search("AbelMaclead").toString());
        System.out.println();
        System.out.println("Delete Carmelina Lindall:");
        list.delete("CarmelinaLindall");
        display(list);
        System.out.println();
        System.out.println("Search phone number start with 215:");
        list.searchPhoneNumber("215");
        System.out.println();
        System.out.println("Search city New Orleans:");
        list.searchSameCity("New Orleans");
        System.out.println();
        System.out.println("Search zip code 99501:");
        list.searchSameZipCode("99501");
    }

    /**
     * Create the address book
     * @param list The list that stored the contact
     */
    public static void create(AddressBook list) {
        File myFile = new File("information.txt");
        BinarySearchTree<Contact, Key> tree = new BinarySearchTree<>();
        Scanner inputFile;
        {
            try {
                inputFile = new Scanner(myFile);
                while (inputFile.hasNext()) {
                    String str = inputFile.nextLine();
                    String[] split = str.split("\t");
                    Address address = new Address(split[2], split[3], split[4], split[5]);
                    Contact contact = new Contact(split[0], split[1], address, split[6]);
                    list.insert(contact);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Display the address book
     * @param list The list that stored the contact
     */
    public static void display(AddressBook list){
        TreeIterator<Contact, Key> iterator1 = new TreeIterator<>(list.getTree());
        iterator1.setInorder();
        iterator1.print();
    }
}
