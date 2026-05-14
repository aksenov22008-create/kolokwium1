import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeathCauseStaticList {
   private List<DeathCauseStatistic> deathCauses = new ArrayList<>();

    public DeathCauseStaticList() {
        this.deathCauses = deathCauses;
    }
    public void repopulate(String path) throws IOException {
        deathCauses.clear();
        DeathCauseStatistic[] data =
                DeathCauseStatistic.fromCsv(path);

        // Dodanie do listy
        for (DeathCauseStatistic stat : data) {

            deathCauses.add(stat);
        }

    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(int year , int n){

        int index = year/5;
        deathCauses.sort(
                Comparator.comparingInt(
                        d -> -d.getDeathsByAgeGroup()[index+1]
                )
        );

        return deathCauses.subList(0, n);

    }
    public String toString() {
        return deathCauses.toString();
    }
}
