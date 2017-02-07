package collins.john;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by johncollins on 2/7/17.
 */
public class PhoneBook {
    Map<String, Integer> phoneBook;

    public PhoneBook(){
        phoneBook = new Map<String, Integer>() {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean containsKey(Object key) {
                return false;
            }

            public boolean containsValue(Object value) {
                return false;
            }

            public Integer get(Object key) {
                return null;
            }

            public Integer put(String key, Integer value) {
                return null;
            }

            public Integer remove(Object key) {
                return null;
            }

            public void putAll(Map<? extends String, ? extends Integer> m) {

            }

            public void clear() {

            }

            public Set<String> keySet() {
                return null;
            }

            public Collection<Integer> values() {
                return null;
            }

            public Set<Entry<String, Integer>> entrySet() {
                return null;
            }
        };

    }//end Phonebook constructor
    public void lookup(String name){

    }
}
