import java.security.PrivateKey;

/**
 * The key of a contact
 * @author Li Yixiao
 * @version 1.0
 */
public class Key implements Comparable<Key>{
    String name;
    public Key (String name){
        this.name=name;
    }

    /**
     * Convert the key to the string
     * @return The string of the key
     */
    public String toString(){
        return this.name;
    }

    @Override
    /**
     * Override the compareTo method
     */
    public int compareTo(Key compared) {
        return this.name.compareTo(compared.name);
    }
}

