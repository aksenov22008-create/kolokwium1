import java.util.*;

public class PersonWithParentString {

    private Person person;
    private String[] parents;

    public PersonWithParentString(Person person,
                                  String[] parents)
    {
        this.person = person;
        this.parents = parents;
    }

    public static PersonWithParentString fromCsvLine(String line)
            throws NegativeLifespanException {

        Person person = Person.fromCsvLine(line);

        /*
         * split(",",-1)
         * ділить рядок по комі.
         */
        String[] columns = line.split(",", -1);

        /*
         * copyOfRange()
         * копіює частину масиву.
         */
        return new PersonWithParentString(
                person,
                Arrays.copyOfRange(columns,3,5)
        );
    }

    public String name(){
        return this.person.name();
    }

    public static void connectRelaives(
            Map<String,PersonWithParentString>
                    peopleMap)
    {

        /*
         * Scanner
         * зчитує текст з консолі.
         */
        Scanner scanner = new Scanner(System.in);

        for(PersonWithParentString child
                : peopleMap.values()){

            for(String parentString
                    : child.parents){

                if(!parentString.isEmpty()){

                    Person parent =
                            peopleMap
                                    .get(parentString)
                                    .person;

                    try {

                        parent.adopt(child.person);

                    }
                    catch (ParentingAgeException e){

                        System.out.println(e.getMessage());

                        System.out.println("Dodac mimo to? Y/N");

                        /*
                         * nextLine()
                         * читає рядок тексту.
                         */
                        String answer = scanner.nextLine();

                        /*
                         * equalsIgnoreCase()
                         * порівняння тексту
                         * без врахування регістру.
                         */
                        if(answer.equalsIgnoreCase("Y")){

                            parent.forceAddChild(child.person);

                            System.out.println("Dodano");
                        }
                        else{

                            System.out.println("Pominieto");
                        }
                    }
                }
            }
        }
    }

    public static List<Person> unpackMap(
            Map<String,PersonWithParentString>
                    people)
    {

        ArrayList<Person> peopleResult =
                new ArrayList<>();

        for(PersonWithParentString
                personWithParentString
                : people.values()){

            peopleResult.add(
                    personWithParentString.person
            );
        }

        return peopleResult;
    }
}