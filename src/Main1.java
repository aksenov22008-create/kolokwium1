import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main1 {

    public static void main(String[] args) throws IOException {
        Point[] points = new Point[5];
        points[0]= new Point(2.3F,5.6F);
        points[1]= new Point(10.5F,12.4F);
        points[2]= new Point(15.4F,74.2F);
        points[3]= new Point(72.4F,71.6F);
        points[4]= new Point(162.4F,51.3F);
        Polygon p1=new Polygon(points);


        Polygon p2 = new Polygon(new Point[]{
                new Point(),
                new Point(10,0),
                new Point(10,10)
        });
        SvgScene scene = new SvgScene();
        scene.addShape(p1);
        scene.addShape(p2);
        System.out.println(scene.toSvg());

        scene.addShape(Polygon.square(new Segment(
                new Point(55.0F,100.0F),
                new Point(100.0F,60.0F)
        ),new Style("red", "green",3.0)));

        scene.addShape(new Ellipse(new Style("red","blue",3.0),new Point(100.F,100.F),20.0F,50.0F));
        scene.save("out.svg");
        System.out.println(p1.boundingBox());

    }
}