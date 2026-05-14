/*
 * Власний клас винятку.
 *
 * Exception — це помилка, яку можна перехопити через try/catch.
 *
 * Ми створюємо свій виняток для ситуації,
 * коли країну не знайдено в CSV.
 */
public class CountryNotFoundException extends Throwable {

    /*
     * Назва країни, яку не знайдено.
     *
     * private — доступ лише всередині класу.
     * final — значення не можна змінити після створення.
     */
    private final String countryName;

    /*
     * Конструктор винятку.
     *
     * Викликається коли пишемо:
     * throw new CountryNotFoundException(...)
     */
    public CountryNotFoundException(String countryName) {

        // Збереження назви країни
        this.countryName = countryName;
    }

    /*
     * Метод getMessage() існує у всіх винятків.
     * Він повертає текст помилки.
     */
    public String getMessage() {

        return countryName;
    }
}