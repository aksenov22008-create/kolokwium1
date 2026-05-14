import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main2 {

    public static void main(String[] args) throws IOException, NegativeLifespanException {
        try{
            List<Person> people = Person.fromCsv("family.csv");
            Person.toBinaryFile(people,"data.bin");
            List<Person> people2 = Person.fromBinaryFile("data.bin");
            System.out.println(people2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParentingAgeException e) {
            throw new RuntimeException(e);
        }
    }
}
