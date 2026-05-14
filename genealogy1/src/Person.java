import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable,Serializable{

    private String firstName;
    private String lastName;
    private LocalDate birthday;

    /*
     * Set
     * зберігає лише унікальні елементи.
     */
    private Set<Person> children = new HashSet<>();

    private LocalDate death;

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
             * порівняння об'єктів.
             */
            if(youngest.compareTo(person)<0){
                youngest=person;
            }
        }

        return youngest;
    }

    public Person(String firstName, String lastName, LocalDate birthday,LocalDate death) throws NegativeLifespanException {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death=death;

        /*
         * isAfter()
         * перевірка чи дата пізніше.
         */
        if(this.death != null && this.birthday.isAfter(this.death)){

            /*
             * throw
             * створення помилки вручну.
             */
            throw new NegativeLifespanException(this);
        }
    }

    public void forceAddChild(Person child){
        children.add(child);
    }

    /*
     * this(...)
     * виклик іншого конструктора.
     */
    public Person (String firstName, String lastName, LocalDate birthday) throws NegativeLifespanException {
        this(firstName,lastName,birthday,null);
    }

    public boolean adopt(Person child)
            throws ParentingAgeException {

        /*
         * this
         * поточний об'єкт.
         */
        if(child == this){
            return false;
        }

        int age =
                child.birthday.getYear()
                        - this.birthday.getYear();

        if(age < 15){
            throw new ParentingAgeException(this, child);
        }

        /*
         * isBefore()
         * перевірка чи дата раніше.
         */
        if(this.death != null &&
                this.death.isBefore(child.birthday))
        {
            throw new ParentingAgeException(this, child);
        }

        return children.add(child);
    }

    public List<Person> getChildren(){

        return children.stream().sorted().toList();
    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {

        /*
         * split(",",-1)
         * ділить текст по комі.
         */
        String[] columns = line.split(",",-1);

        String fullName = columns[0];

        String[]  name = fullName.split(" ");

        String fname = name[0];
        String lname = name[1];

        String birth = columns[1];
        String death = columns[2];

        /*
         * DateTimeFormatter
         * форматування дати.
         */
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d.M.y");

        /*
         * LocalDate.parse()
         * String -> дата.
         */
        LocalDate birthdate = LocalDate.parse(birth,formatter);

        LocalDate deathdate =null;

        if(!death.isEmpty()){
            deathdate = LocalDate.parse(death,formatter);
        }

        return new Person(fname,lname,birthdate,deathdate);
    }

    public static List<Person> fromCsv(String path) throws IOException, ParentingAgeException {

        Map<String, PersonWithParentString> people = new HashMap<>();

        /*
         * BufferedReader
         * читає файл по рядках.
         */
        BufferedReader file = new BufferedReader(new FileReader(path));

        file.readLine();

        String line;

        /*
         * while
         * працює поки рядок != null.
         */
        while((line = file.readLine()) != null){

            try {

                PersonWithParentString newPerson = PersonWithParentString.fromCsvLine(line);

                people.put(newPerson.name(),newPerson);

            } catch (NegativeLifespanException e) {

                /*
                 * System.err
                 * вивід помилок.
                 */
                System.err.println(e.getMessage());
            }
        }

        file.close();

        PersonWithParentString.connectRelaives(people);

        return PersonWithParentString.unpackMap(people);
    }

    public String name(){
        return String.format("%s %s",firstName,lastName);
    }

    public int compareTo(Person other){
        return this.birthday.compareTo(other.birthday);
    }

    public static void toBinaryFile(List<Person> people, String path) throws IOException {

        /*
         * ObjectOutputStream
         * запис об'єктів у файл.
         */
        FileOutputStream fos = new FileOutputStream(path);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(people);

        oos.close();
    }

    public static List<Person> fromBinaryFile(String path) throws IOException, ClassNotFoundException {

        /*
         * ObjectInputStream
         * зчитування об'єктів.
         */
        FileInputStream fis = new FileInputStream(path);

        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Person> people = (List<Person>) ois.readObject();

        /*
         * (List<Person>)
         * перетворення типу.
         */
        ois.close();

        return people;
    }

    @Override
    public String toString() {
        return "Person{"+" firstName='"+firstName+"'"+" lastName='"+lastName+"'"+" birthday="+birthday+" children="+children+"death"+death+"}";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String negativeLifespanExceptionMessege() {

        return String.format(
                "Osoba %s %s ma dae smierci %s wczesniejsza niz data urodzenia %s",
                this.firstName,this.lastName,this.death,this.birthday);

    }
}