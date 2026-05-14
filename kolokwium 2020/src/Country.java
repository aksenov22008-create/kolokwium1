import java.io.*;
import java.time.LocalDate;
import java.util.List;

/*
 * abstract class
 * базовий клас для інших країн.
 *
 * Не можна створити:
 * new Country(...)
 */
public abstract class Country {

    // final -> значення не змінюється
    private final String name;

    // static -> поле спільне для всіх об'єктів
    private static String countriesFilePath;
    private static String provincesFilePath;

    /*
     * Getter назви країни.
     */
    public String getName() {
        return name;
    }

    /*
     * Конструктор класу.
     */
    public Country(String name)  {
        this.name = name;
    }

    /*
     * static метод викликається через клас:
     * Country.setFiles(...)
     */
    public static void setFiles(String countriesFilePath,
                                String provincesFilePath)
            throws FileNotFoundException {

        File countries = new File(countriesFilePath);
        File provinces = new File(provincesFilePath);

        /*
         * exists() -> файл існує
         * canRead() -> файл можна читати
         */
        if(!countries.exists() || !countries.canRead()){
            throw new FileNotFoundException();
        }

        if(!provinces.exists() || !provinces.canRead()){
            throw new FileNotFoundException();
        }

        Country.countriesFilePath = countriesFilePath;
        Country.provincesFilePath = provincesFilePath;
    }

    /*
     * Зчитування країни з CSV.
     */
    public static Country fromCsv(String country)
            throws IOException, CountryNotFoundException {

        /*
         * BufferedReader читає файл по рядках.
         *
         * readLine() читає один рядок.
         */
        BufferedReader countriesReader =
                new BufferedReader(
                        new FileReader(countriesFilePath)
                );

        BufferedReader deathsReader =
                new BufferedReader(
                        new FileReader(provincesFilePath)
                );

        String countriesHeader =
                countriesReader.readLine();

        String provincesHeader =
                countriesReader.readLine();

        deathsReader.readLine();
        deathsReader.readLine();

        CountryColumns columns =
                getCountryColumns(
                        countriesHeader,
                        country
                );

        /*
         * split(";")
         * ділить рядок по символу ;
         */
        String[] provinceNames =
                provincesHeader.split(";");

        String countriesLine;
        String deathsLine;

        /*
         * Якщо одна колонка —
         * країна без провінцій.
         */
        if (columns.columnCount == 1) {

            CountryWithoutProvinces countryObject =
                    new CountryWithoutProvinces(country);

            /*
             * while працює поки рядок != null
             */
            while ((countriesLine =
                    countriesReader.readLine()) != null
                    &&
                    (deathsLine =
                            deathsReader.readLine()) != null) {

                String[] confirmedSplit =
                        countriesLine.split(";");

                String[] deathsSplit =
                        deathsLine.split(";");

                /*
                 * LocalDate.parse(...)
                 * текст -> дата
                 *
                 * parseInt(...)
                 * String -> int
                 */
                countryObject.addDailyStatic(
                        LocalDate.parse(
                                confirmedSplit[0]
                        ),

                        Integer.parseInt(
                                confirmedSplit[
                                        columns.firstColumnIndex
                                        ]
                        ),

                        Integer.parseInt(
                                deathsSplit[
                                        columns.firstColumnIndex
                                        ]
                        )
                );
            }

            countriesReader.close();
            deathsReader.close();

            return countryObject;
        }

        /*
         * Масив провінцій.
         */
        Country[] provinces =
                new Country[columns.columnCount];

        /*
         * for цикл проходить по індексах масиву.
         */
        for (int i = 0; i < columns.columnCount; i++) {

            provinces[i] =
                    new CountryWithoutProvinces(
                            provinceNames[
                                    columns.firstColumnIndex + i
                                    ]
                    );
        }

        CountryWithProvinces countryObject =
                new CountryWithProvinces(
                        country,
                        provinces
                );

        while ((countriesLine =
                countriesReader.readLine()) != null
                &&
                (deathsLine =
                        deathsReader.readLine()) != null) {

            String[] confirmedSplit =
                    countriesLine.split(";");

            String[] deathsSplit =
                    deathsLine.split(";");

            for (int i = 0; i < columns.columnCount; i++) {

                /*
                 * (CountryWithoutProvinces)
                 * перетворення типу об'єкта.
                 */
                ((CountryWithoutProvinces)
                        provinces[i]).addDailyStatic(

                        LocalDate.parse(
                                confirmedSplit[0]
                        ),

                        Integer.parseInt(
                                confirmedSplit[
                                        columns.firstColumnIndex + i
                                        ]
                        ),

                        Integer.parseInt(
                                deathsSplit[
                                        columns.firstColumnIndex + i
                                        ]
                        )
                );
            }
        }

        countriesReader.close();
        deathsReader.close();

        return countryObject;
    }

    /*
     * abstract методи.
     *
     * Реалізація буде
     * у дочірніх класах.
     */
    public abstract int getConfirmedCases(LocalDate date);

    public abstract int getDeaths(LocalDate date);

    /*
     * Сортування країн по смертях.
     */
    public static void sortByDeaths(List<Country> countries,
                                    LocalDate startDate,
                                    LocalDate endDate) {

        /*
         * lambda вираз
         * короткий запис функції.
         */
        countries.sort((c1, c2) -> {

            int deaths1 = 0;
            int deaths2 = 0;

            LocalDate currentDate = startDate;

            /*
             * plusDays(1)
             * додає 1 день до дати.
             */
            while(!currentDate.isAfter(endDate)) {

                deaths1 += c1.getDeaths(currentDate);
                deaths2 += c2.getDeaths(currentDate);

                currentDate =
                        currentDate.plusDays(1);
            }

            return deaths2 - deaths1;
        });
    }

    /*
     * Збереження статистики у файл.
     */
    public void saveToDateFile(String path)
            throws IOException {

        PrintWriter writer =
                new PrintWriter(
                        new FileWriter(path)
                );

        /*
         * instanceof
         * перевіряє тип об'єкта.
         */
        if(this instanceof CountryWithoutProvinces) {

            CountryWithoutProvinces country =
                    (CountryWithoutProvinces)this;

            /*
             * foreach цикл проходить
             * по всіх елементах списку.
             */
            for(CountryWithoutProvinces.DailyStatic d
                    : country.getStatistic()) {

                writer.println(
                        d.getDate()
                                + "\t"
                                + getConfirmedCases(d.getDate())
                                + "\t"
                                + getDeaths(d.getDate())
                );
            }
        }

        writer.close();
    }

    /*
     * Пошук колонок країни в CSV.
     */
    private static CountryColumns getCountryColumns(
            String line,
            String country)
            throws CountryNotFoundException {

        String[] split = line.split(";");

        int firstColumnIndex = -1;
        int columnCount = 0;

        for (int i = 0; i < split.length; i++) {

            /*
             * equals()
             * порівнює текст.
             */
            if (split[i].equals(country)) {

                if (firstColumnIndex == -1) {
                    firstColumnIndex = i;
                }

                columnCount++;
            }
        }

        /*
         * throw
         * створює помилку вручну.
         */
        if (firstColumnIndex == -1) {
            throw new CountryNotFoundException(country);
        }

        return new CountryColumns(
                firstColumnIndex,
                columnCount
        );
    }

    /*
     * Внутрішній клас
     * для збереження колонок CSV.
     */
    private static class CountryColumns{

        public final int firstColumnIndex;
        public final int columnCount;

        public CountryColumns(int firstColumnIndex,
                              int columnCount) {

            this.firstColumnIndex = firstColumnIndex;
            this.columnCount = columnCount;
        }
    }
}