public class ShapeDecorator implements Shape{

    /*
     * protected
     * доступний у дочірніх класах.
     */
    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public BoundingBox boundingBox() {

        /*
         * Виклик методу
         * внутрішньої фігури.
         */
        return decoratorShape.boundingBox();
    }

    @Override
    public String toSvg() {
        return null;
    }
}