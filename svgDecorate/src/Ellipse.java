import java.util.Locale;

public class Ellipse implements Shape{

    // центр еліпса
    private Vec2 center;

    // радіуси
    private double rx, ry;

    public Ellipse(Vec2 center, double rx, double ry) {
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public BoundingBox boundingBox() {

        /*
         * boundingBox
         * область яку займає фігура.
         */
        return new BoundingBox(
                center.x() - rx,
                center.y() - ry,
                rx * 2,
                ry * 2
        );
    }

    @Override
    public String toSvg() {

        /*
         * String.format(...)
         * вставляє значення у текст.
         *
         * Locale.ENGLISH
         * числа через крапку.
         */
        return String.format(Locale.ENGLISH,
                "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\"/>",
                rx,ry,center.x(),center.y());
    }
}