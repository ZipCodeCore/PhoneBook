package armstrong.alexandra;

import java.util.TreeMap;

public class PhoneBook extends TreeMap {

    public String lookUp(String name){
        return (String)get(name);
    }

    public void add(String name, String number){
        put(name, number);
    }

    public void add(String name, int[] number){
        String fixedNumber = "(" + number[0] + number[1] + number[2] + ") " + number[3] + number[4] + number[5] + "-" + number[6] + number[7] + number[8] + number[9];
        put(name, fixedNumber);
    }

    public void listAllNames(){
        for(Object x : keySet()) {
            System.out.println((String) x);
        }
    }

    public void listAllEntries(){
        for(Object x : keySet()){
            System.out.println((String)x + lookUp((String)x));
        }
    }
}
