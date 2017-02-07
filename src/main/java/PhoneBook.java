import java.util.TreeMap;

/**
 * Created by randallcrame on 2/7/17.
 */
public class PhoneBook {



    private TreeMap<String, String> addressBook = new TreeMap<>();

    public TreeMap<String, String> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(TreeMap<String, String> addressBook) {
        this.addressBook = addressBook;
    }

    public String lookUp(String K){
        return null;
    }

    public void add(String K, String V){

    }
    public void remove(String K){

    }

    public String printNameList(){
        return null;
    }

    public String printEntryList(){
        return null;
    }

    public String reverseLookUp(String V){
        return null;
    }
}
