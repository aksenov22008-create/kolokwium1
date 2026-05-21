import java.util.Locale;

public class Style {
    // final oznacza, że raz ustawione pole, nie może być modyfikowane
    public final String fillColor, strokeColor;
    public final double strokeWidth;

    public Style(String fillColor, String strokeColor, double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH,
                "fill:%s;stroke:%s;stroke-width:%f",
                fillColor, strokeColor, strokeWidth
        );
    }
}
