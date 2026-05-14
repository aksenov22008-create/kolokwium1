// abstract = абстрактний клас
// Такий клас НЕ можна створити через new
// Він потрібен як "база" для інших фігур

public abstract class Shape {

    // protected =
    // доступний:
    // - всередині цього класу
    // - у класах які наслідують Shape

    protected Style style;



    // Конструктор базового класу

    public Shape(Style style) {

        // зберігаємо стиль фігури
        this.style = style;
    }



    // abstract метод
    // У Shape немає конкретної реалізації

    // Кожна фігура сама вирішує
    // як генерувати SVG

    public abstract String toSvg();
}