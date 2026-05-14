import java.time.LocalDate;
import java.util.ArrayList;

/*
 * Клас країни БЕЗ провінцій.
 *
 * extends Country
 * означає наслідування.
 *
 * CountryWithoutProvinces отримує:
 * - поля
 * - методи
 * з класу Country.
 */
public class CountryWithoutProvinces extends Country {

    /*
     * ArrayList — динамічний масив.
     *
     * Він може автоматично збільшуватись.
     *
     * Тут зберігається статистика по днях.
     */
    private ArrayList<DailyStatic> statistic =
            new ArrayList<>();

    /*
     * Конструктор.
     *
     * super(name)
     * викликає конструктор батьківського класу.
     */
    public CountryWithoutProvinces(String name) {

        super(name);
    }

    /*
     * Додавання статистики за день.
     */
    public void addDailyStatic(LocalDate date,
                               int infection,
                               int dead) {

        /*
         * Створення нового об’єкта DailyStatic
         * і додавання його в список.
         */
        statistic.add(
                new DailyStatic(
                        date,
                        infection,
                        dead
                )
        );
    }

    /*
     * Getter для списку статистики.
     */
    public ArrayList<DailyStatic> getStatistic() {

        return statistic;
    }

    /*
     * Пошук заражень за датою.
     */
    public int getConfirmedCases(LocalDate date) {

        /*
         * foreach цикл.
         *
         * Проходить по всіх елементах списку.
         */
        for(DailyStatic d : statistic) {

            /*
             * equals()
             * порівнює об’єкти.
             */
            if(d.date.equals(date)) {

                return d.infection;
            }
        }

        return 0;
    }

    /*
     * Пошук смертей за датою.
     */
    public int getDeaths(LocalDate date) {

        for(DailyStatic d : statistic) {

            if(d.date.equals(date)) {

                return d.dead;
            }
        }

        return 0;
    }

    /*
     * Внутрішній клас.
     *
     * Зберігає статистику одного дня.
     */
    public static class DailyStatic {

        // Дата
        private LocalDate date;

        // Кількість заражень
        private int infection;

        // Кількість смертей
        private int dead;

        /*
         * Конструктор статистики.
         */
        public DailyStatic(LocalDate date,
                           int infection,
                           int dead) {

            this.date = date;
            this.infection = infection;
            this.dead = dead;
        }

        /*
         * Getter-и
         * повертають значення полів.
         */

        public LocalDate getDate() {
            return date;
        }

        public int getInfection() {
            return infection;
        }

        public int getDead() {
            return dead;
        }
    }
}