import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski", LocalDate.of(1993, Month.JANUARY, 2)));
        people.add(new Person("Jana", "Kowalska", LocalDate.of(1992, Month.FEBRUARY, 20)));
        people.add(new Person("Anna", "Jakubna", LocalDate.of(1993, Month.APRIL, 12)));
        people.add(new Person("Jana", "Kowalska", LocalDate.of(2016, Month.JULY, 12)));
        people.add(new Person("Vlad", "Kowalska", LocalDate.of(2014, Month.JULY, 22)));
        Person child = people.get(3);
        Person child1 = people.get(4);
        Person parent = people.get(1);
        System.out.println(parent.adopt(child));
        System.out.println(parent.adopt(child1));
        System.out.println(parent.adopt(parent));
        System.out.println(parent.getYoungestChild());
        System.out.println(parent.getChildren());
        System.out.println(people);

        Family family = new Family();

        Person p1 = new Person(
                "Jan",
                "Kowalski",
                LocalDate.of(1990, 1, 1)
        );

        Person p2 = new Person(
                "Jan",
                "Kowalski",
                LocalDate.of(2010, 1, 1)
        );

        Person p3 = new Person(
                "Jan",
                "Kowalski",
                LocalDate.of(2000, 1, 1)
        );

        family.add(p1, p2, p3);

        List<Person> result =
                family.get("Jan Kowalski");

        System.out.println(result);
    }
}
