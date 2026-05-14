public class SolidFillShapeDecorator extends ShapeDecorator{

    // колір заливки
    private String color;

    public SolidFillShapeDecorator(Shape decoratorShape,
                                   String color) {

        /*
         * super(...)
         * виклик конструктора батьківського класу.
         */
        super(decoratorShape);

        this.color = color;
    }

    @Override
    public String toSvg() {

        return decoratorShape.toSvg().replace("/>",
                String.format("fill=\"%s\"/>",color));
    }
}