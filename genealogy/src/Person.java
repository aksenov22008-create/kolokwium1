import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDate dead_date;

    /*
     * Set
     * зберігає лише унікальні елементи.
     */
    private Set<Person> children = new HashSet<>();

    public Person getYoungestChild(){

        /*
         * isEmpty()
         * перевіряє чи колекція порожня.
         */
        if( this.children.isEmpty())return null;

        /*
         * iterator()
         * використовується для проходу
         * по колекції.
         */
        Person youngest = children.iterator().next();

        for(Person person : children){

            /*
             * compareTo()
             * порівнює об'єкти.
             */
            if(youngest.compareTo(person)>0){
                youngest=person;
            }
        }

        return youngest;
    }

    public Person(String firstName,
                  String lastName,
                  LocalDate birthday,
                  LocalDate dead_date) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.dead_date = dead_date;
    }

    /*
     * this(...)
     * викликає інший конструктор.
     */
    public Person(String firstName,
                  String lastName,
                  LocalDate birthday ){

        this(firstName,lastName,birthday,null);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean adopt(Person child){

        /*
         * this
         * поточний об'єкт.
         */
        if(child == this){return false;}

        return children.add(child);
    }

    public List<Person> getChildren(){

        return children.stream().sorted().toList();
    }

    public int compareTo(Person other){

        return this.birthday.compareTo(other.birthday);
    }

    public Person fromCsvLine(String path){

        /*
         * split(",")
         * ділить текст по комі.
         */
        String[] fields = path.split(",");

        String fullname= fields[0];

        String[] tmp = fullname.split(" ");

        String firstName = tmp[0];
        String lastName = tmp[1];

        /*
         * LocalDate.parse()
         * String -> дата.
         */
        LocalDate birth = LocalDate.parse(fields[1]);
        LocalDate dead = LocalDate.parse(fields[2]);

        /*
         * DateTimeFormatter
         * форматування дати.
         */
        DateTimeFormatter formatter=
                DateTimeFormatter.ofPattern("d.M.y");

        return new Person(firstName,lastName,birth,dead);
    }

    @Override
    public String toString() {

        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", dead_date=" + dead_date +
                ", children=" + children +
                '}';
    }

}