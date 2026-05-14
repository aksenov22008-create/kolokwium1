public class SolidFilledPolygon extends Polygon {

    // колір заливки
    private String color;

    /*
     * super(points)
     * викликає конструктор Polygon.
     */
    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toSvg(){

        /*
         * super.toSvg()
         * викликає метод батьківського класу.
         *
         * replace()
         * замінює текст у рядку.
         */
        return super.toSvg().replace("/>",
                String.format("fill=\"%s\"/>",color));
    }
}