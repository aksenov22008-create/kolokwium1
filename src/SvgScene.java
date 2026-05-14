import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

// Клас сцени SVG

public class SvgScene {

    // масив фігур
    private Shape[] poly = new Shape[3];

    // індекс наступного елемента
    private int index = 0;



    // Додає фігуру

    public void addShape(Shape p){

        poly[index] = p;

        index++;



        // якщо дійшли до кінця
        // починаємо спочатку

        if(index == 3){

            index = 0;
        }
    }



    // Створює SVG код

    public String toSvg(){

        // StringBuilder швидко збирає текст
        StringBuilder polygonsString =
                new StringBuilder();



        // перебираємо всі фігури

        for(Shape p : poly){

            // якщо не null
            if(p != null){

                polygonsString
                        .append(p.toSvg())
                        .append("\n");
            }
        }



        // повертаємо повний SVG

        return String.format(
                Locale.ENGLISH,

                "<svg height=\"100\" width=\"100\" xmlns=\"http://www.w3.org/2000/svg\">%s</svg>",

                polygonsString
        );
    }



    // Зберігає SVG у файл

    public void save(String path)
            throws IOException {

        // відкриваємо файл
        FileWriter writer =
                new FileWriter(path);



        // записуємо текст
        writer.write(toSvg());



        // закриваємо файл
        writer.close();
    }
}