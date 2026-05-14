import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeathCauseStaticList {

    /*
     * List
     * список об'єктів.
     */
    private List<DeathCauseStatistic> deathCauses = new ArrayList<>();

    public DeathCauseStaticList() {

        /*
         * this
         * поточний об'єкт.
         */
        this.deathCauses = deathCauses;
    }

    public void repopulate(String path) throws IOException {

        /*
         * clear()
         * очищення списку.
         */
        deathCauses.clear();

        /*
         * fromCsv(...)
         * зчитування CSV файлу.
         */
        DeathCauseStatistic[] data = DeathCauseStatistic.fromCsv(path);

        /*
         * foreach цикл
         * проходить по масиву.
         */
        for (DeathCauseStatistic stat : data) {
            deathCauses.add(stat);
        }

    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int year , int n){

        int index = year/5;

        /*
         * sort(...)
         * сортування списку.
         */
        deathCauses.sort(

                /*
                 * Comparator
                 * об'єкт для сортування.
                 */
                Comparator.comparingInt(

                        /*
                         * lambda
                         * коротка функція.
                         */
                        d -> -d.getDeathsByAgeGroup()[index+1]
                )
        );

        /*
         * subList()
         * частина списку.
         */
        return deathCauses.subList(0, n);

    }

    public String toString() {
        return deathCauses.toString();
    }
}