import java.time.LocalDate;

/*
 * Клас країни з провінціями.
 *
 * extends Country
 * означає наслідування
 * від базового класу Country.
 */
public class CountryWithProvinces
        extends Country {

    /*
     * Масив провінцій країни.
     *
     * Country[]
     * масив об'єктів Country.
     */
    private Country[] provinces;

    /*
     * Конструктор класу.
     */
    public CountryWithProvinces(String name,
                                Country[] countries) {

        /*
         * super(name)
         * викликає конструктор
         * батьківського класу.
         */
        super(name);

        this.provinces = countries;
    }

    /*
     * Метод повертає
     * кількість заражень
     * за конкретну дату.
     */
    public int getConfirmedCases(LocalDate date) {

        int sum = 0;

        /*
         * foreach цикл
         * проходить по всіх провінціях.
         *
         * c — поточна провінція.
         */
        for(Country c : provinces){

            /*
             * +=
             * додає значення до змінної.
             */
            sum += c.getConfirmedCases(date);
        }

        return sum;
    }

    /*
     * Метод повертає
     * кількість смертей
     * за конкретну дату.
     */
    public int getDeaths(LocalDate date) {

        int sum = 0;

        for(Country c : provinces){

            sum += c.getDeaths(date);
        }

        return sum;
    }
}