// Клас Segment = відрізок
// Має 2 точки

public class Segment {

    // початок відрізка
    private Point p1;

    // кінець відрізка
    private Point p2;



    // Конструктор

    public Segment(Point p1, Point p2){

        this.p1 = p1;
        this.p2 = p2;
    }



    // повертає першу точку

    public Point getP1() {
        return p1;
    }



    // повертає другу точку

    public Point getP2() {
        return p2;
    }



    // Красивий вивід в консоль

    @Override
    public String toString() {

        return "Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }



    // Обчислення довжини відрізка

    public float length(){

        // Math.hypot(a,b)
        // рахує:
        // sqrt(a²+b²)

        return (float)Math.hypot(
                p1.getX() - p2.getX(),
                p1.getY() - p2.getY()
        );
    }



    // static = метод належить класу
    // а не об'єкту

    // Пошук найдовшого відрізка

    public static Segment findMax(Segment[] segments){

        // поки що максимум = перший елемент
        Segment max = segments[0];



        // цикл foreach
        // перебирає всі елементи масиву

        for(Segment s : segments){

            // якщо поточний більший
            if(s.length() > max.length()){

                // оновлюємо максимум
                max = s;
            }
        }

        return max;
    }



    // Створює перпендикулярний відрізок

    public Segment perpendicular(){

        // координати точок
        float x1 = p1.getX();
        float x2 = p2.getX();

        float y1 = p1.getY();
        float y2 = p2.getY();



        // середина відрізка

        float midx = (x1 + x2) / 2f;
        float midy = (y1 + y2) / 2f;



        // половина вектора

        float dx = (x1 - x2) / 2f;
        float dy = (y1 - y2) / 2f;



        // створюємо нові точки
        // повернуті на 90 градусів

        Point p3 = new Point(
                midx - dy,
                midy + dx
        );

        Point p4 = new Point(
                midx + dy,
                midy - dx
        );



        // повертаємо новий відрізок

        return new Segment(p3,p4);
    }
}