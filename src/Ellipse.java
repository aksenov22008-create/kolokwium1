import java.util.Locale;

// Ellipse НАСЛІДУЄ Shape
// extends = успадковує

public class Ellipse extends Shape {

    // центр еліпса
    private Point center;

    // радіуси
    private float rx;
    private float ry;



    // Конструктор

    public Ellipse(
            Style style,
            Point center,
            float rx,
            float ry
    ) {

        // виклик конструктора Shape
        super(style);

        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }



    // Генерація SVG

    public String toSvg() {

        return String.format(
                Locale.ENGLISH,

                // SVG еліпс
                "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" style=\"%s\" />",

                // rx
                rx,

                // ry
                ry,

                // cx
                center.getX(),

                // cy
                center.getY(),

                // стиль
                style.toSvg()
        );
    }
}