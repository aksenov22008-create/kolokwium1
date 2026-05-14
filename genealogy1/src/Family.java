import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {

    /*
     * Map<Key,Value>
     * ключ -> значення.
     */
    private Map<String,List<Person>> family = new HashMap<>();

    /*
     * Person...
     * можна передати багато об'єктів.
     */
    public void add(Person... persons) {

        for(Person person : persons){

            String key = person.name();

            /*
             * containsKey()
             * перевіряє чи є ключ.
             */
            if(!family.containsKey(key)){
                family.put(key, new ArrayList<>());
            }

            family.get(key).add(person);
        }
    }

    public List<Person> get(String key){

        List<Person> people = family.get(key);

        /*
         * null
         * означає відсутність об'єкта.
         */
        if(people == null){
            return null;
        }

        /*
         * stream()
         * робота з колекцією.
         *
         * sorted()
         * сортування елементів.
         */
        List<Person> sorted =
                people.stream()
                        .sorted()
                        .toList();

        return people.stream().sorted().toList();
    }
}