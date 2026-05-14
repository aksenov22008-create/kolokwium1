import java.util.Arrays;
import java.util.Locale;

// Polygon наслідує Shape

public class Polygon extends Shape {

    // масив точок
    private Point[] points;



    // Конструктор

    public Polygon(Point[] points, Style style) {

        // викликаємо Shape
        super(style);

        // створюємо новий масив
        this.points = new Point[points.length];



        // копіюємо точки

        for(int i = 0; i < points.length; i++){

            this.points[i] = new Point(points[i]);
        }
    }



    // Конструктор зі стилем по замовчуванню

    public Polygon(Point[] points){

        this(
                points,
                new Style(
                        "transparent",
                        "black",
                        1.0
                )
        );
    }



    @Override
    public String toString() {

        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }



    // Генерація SVG

    public String toSvg(){

        // рядок для всіх точок
        String pointstring = "";



        // додаємо точки

        for(Point p : points){

            pointstring +=
                    p.getX() + "," +
                            p.getY() + " ";
        }



        return String.format(
                Locale.ENGLISH,

                "<polygon points=\"%s\" %s/>",

                pointstring,

                style.toSvg()
        );
    }



    // Розрахунок bounding box

    public BoundingBox boundingBox() {

        // якщо точок нема

        if(points.length == 0){

            return new BoundingBox(
                    0,
                    0,
                    0,
                    0
            );
        }



        // початкові значення

        float minX = points[0].getX();
        float maxX = points[0].getX();

        float minY = points[0].getY();
        float maxY = points[0].getY();



        // шукаємо мінімум і максимум

        for(Point p : points){

            if(p.getX() < minX)
                minX = p.getX();

            if(p.getX() > maxX)
                maxX = p.getX();

            if(p.getY() < minY)
                minY = p.getY();

            if(p.getY() > maxY)
                maxY = p.getY();
        }



        // створюємо bounding box

        return new BoundingBox(
                minX,
                minY,
                maxX - minX,
                maxY - minY
        );
    }



    // static метод створення квадрата

    public static Polygon square(
            Segment s,
            Style style
    ){

        // перпендикуляр
        Segment perp = s.perpendicular();



        // масив з 4 точок
        Point[] p = new Point[4];

        p[0] = s.getP1();
        p[1] = perp.getP1();
        p[2] = s.getP2();
        p[3] = perp.getP2();



        // створюємо полігон

        return new Polygon(p,style);
    }
}