// Підключаємо Locale.ENGLISH
// Це потрібно щоб числа писались через крапку (5.6)
// а не через кому (5,6)
import java.util.Locale;

// public = клас можна використовувати будь-де
// class = шаблон для створення об'єктів
public class Point {

    // private = доступ тільки всередині класу
    // float = дробове число

    // координата X
    private float x;

    // координата Y
    private float y;



    // КОНСТРУКТОР БЕЗ ПАРАМЕТРІВ
    // Викликається коли пишемо:
    // new Point()

    public Point(){

        // точка створиться в координатах (0,0)
        x = 0;
        y = 0;
    }



    // КОНСТРУКТОР З ПАРАМЕТРАМИ
    // Викликається коли пишемо:
    // new Point(5,10)

    public Point(float x, float y) {

        // this.x = поле об'єкта
        // x = параметр конструктора

        // записуємо значення в поле x
        this.x = x;

        // записуємо значення в поле y
        this.y = y;
    }



    // КОНСТРУКТОР КОПІЮВАННЯ
    // Створює копію іншої точки

    public Point(Point p){

        // беремо x з іншої точки
        this.x = p.x;

        // беремо y з іншої точки
        this.y = p.y;
    }



    // SetX змінює координату X
    // void = метод нічого не повертає

    public void SetX(float x){

        // міняємо x
        this.x = x;
    }



    // SetY змінює координату Y

    public void SetY(float y){

        // міняємо y
        this.y = y;
    }



    // getX повертає x
    // return = повернути значення

    public float getX(){

        return x;
    }



    // getY повертає y

    public float getY(){

        return y;
    }



    // toString автоматично викликається коли:
    // System.out.println(point)

    @Override
    public String toString() {

        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }



    // Метод створює SVG код точки
    // SVG = мова для малювання фігур

    public String toSvg(){

        // String.format вставляє значення в текст
        // %f = вставити float число

        return String.format(
                Locale.ENGLISH,

                // SVG коло
                "<circle r=\"45\" cx=\"%f\" cy=\"%f\" fill=\"red\"/>",

                // cx = x координата
                x,

                // cy = y координата
                y
        );
    }



    // Метод пересуває ПОТОЧНУ точку
    // dx = зміщення по x
    // dy = зміщення по y

    public void tranclate(float dx, float dy){

        // x = x + dx
        x += dx;

        // y = y + dy
        y += dy;
    }



    // Метод створює НОВУ пересунуту точку
    // Поточна точка НЕ міняється

    public Point translated(float dx,float dy){

        // створюємо копію поточної точки
        Point newPoint = new Point(this);

        // пересуваємо копію
        newPoint.x += dx;
        newPoint.y += dy;

        // повертаємо нову точку
        return newPoint;
    }

}