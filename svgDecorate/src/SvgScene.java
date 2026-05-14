import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SvgScene {

    // масив фігур
    private Shape[] shapes = new Shape[30];

    // індекс наступної фігури
    private int index = 0;

    public void addShape(Shape shape) {

        /*
         * index++
         * після використання
         * збільшує index на 1.
         */
        shapes[(index++) % shapes.length] = shape;
    }

    private BoundingBox sceneBox() {

        double maxX = 0, maxY = 0;

        /*
         * foreach цикл
         * проходить по всіх фігурах.
         */
        for(Shape shape: shapes) {

            /*
             * continue
             * пропускає ітерацію циклу.
             */
            if(shape == null)
                continue;

            BoundingBox shapeBB =
                    shape.boundingBox();

            /*
             * Math.max()
             * повертає більше число.
             */
            maxX = Math.max(maxX,
                    shapeBB.x() + shapeBB.width());

            maxY = Math.max(maxY,
                    shapeBB.y() + shapeBB.height());
        }

        return new BoundingBox(0, 0, maxX, maxY);
    }

    public String toSvg()
    {
        BoundingBox boundingBox = this.sceneBox();

        String result = String.format(
                Locale.ENGLISH,

                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">",

                boundingBox.width(),
                boundingBox.height()
        );

        /*
         * var
         * Java сама визначає тип.
         */
        for(var shape : shapes) {

            if(shape ==  null)
                continue;

            result += "\n\t" + shape.toSvg();
        }

        result += "\n</svg>";

        return result;
    }

    public void save(String path)
            throws IOException {

        /*
         * FileWriter
         * записує текст у файл.
         */
        FileWriter writer =
                new FileWriter(path);

        writer.write(toSvg());

        writer.close();
    }
}