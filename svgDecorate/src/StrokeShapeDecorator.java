public class StrokeShapeDecorator extends ShapeDecorator{

    // колір контуру
    private String color;

    // товщина лінії
    private double width;

    public StrokeShapeDecorator(Shape decoratorShape,
                                String color,
                                double width) {

        super(decoratorShape);

        this.color = color;
        this.width = width;
    }

    public String toSvg() {

        /*
         * %s -> String
         * %f -> double
         */
        return decoratorShape.toSvg().replace("/>",
                String.format(
                        "stroke=\"%s\" stroke-width=\"%f\" />",
                        color,
                        width
                ));
    }
}