import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Shape triangle =new TransformationDecorator(new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        }),new Vec2(20,30),15,new Vec2(10,15));

        Shape rectangle = new SolidFillShapeDecorator(new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        }),"green");

        Shape pentagon = new StrokeShapeDecorator(new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        }),"green",10);

        Ellipse ellipse = new Ellipse(new Vec2(500, 700), 400, 100);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.save("result.svg");
    }
}
