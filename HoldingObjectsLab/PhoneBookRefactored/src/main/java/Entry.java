import java.util.ArrayList;

/**
 * Created by eugenevendensky on 2/7/17.
 */
public class Entry {

    private ArrayList<String> numbers = new ArrayList<String>();

    public Entry(String number){
        numbers.add(number);
    }
    public void addPhoneNumber(String number){
        numbers.add(number);
    }
    public void removeNumber(int index){
        numbers.remove(index);
    }
    public String getNumber(int index){
        String number = numbers.get(index);
        return number;
    }
    public String getNumbers(){
       String allNumbers = numbers.toString();
       return allNumbers;
    }

}
