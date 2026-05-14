import java.util.Locale;

// Клас зберігає стиль фігури:
// колір заливки
// колір контуру
// товщину контуру

public class Style {

    // final = значення не можна змінити після створення

    // fillColor = колір всередині фігури
    public final String fillColor;

    // strokeColor = колір контуру
    public final String strokeColor;

    // товщина лінії
    public final double strokeWidth;



    // Конструктор

    public Style(String fillColor,
                 String strokeColor,
                 double strokeWidth) {

        // записуємо значення в поля об'єкта
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }



    // Метод створює SVG стиль

    public String toSvg(){

        // String.format вставляє значення в текст

        return String.format(
                Locale.ENGLISH,

                // SVG style
                "style=\"fill:%s;stroke:%s;stroke-width:%f\"",

                // %s = String
                fillColor,

                // другий %s
                strokeColor,

                // %f = число
                strokeWidth
        );
    }
}