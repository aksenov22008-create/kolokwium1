import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main3 {

    public static void main(String[] args) throws IOException {
        List<DeathCauseStatistic> people = List.of(DeathCauseStatistic.fromCsv("zgony.csv"));
        System.out.println(people);
        DeathCauseStatistic tmp =people.get(0);
        System.out.println(tmp);
        System.out.println(tmp.DeathCauseStatistic(0,65));
        DeathCauseStaticList list =
                new DeathCauseStaticList();

        list.repopulate("zgony.csv");

        System.out.println(
                list.mostDeadlyDiseases(16,5)
        );
        ICDCodeTabular table1 =
                new ICDCodeTabularOptimizedForTime(
                        "icd.txt");

        System.out.println(
                table1.getDescription("A00")
        );

        ICDCodeTabular table2 =
                new ICDCodeTabularOptimizedForMemory(
                        "icd.txt");

        System.out.println(
                table2.getDescription("A04.7")
        );
    }

}
