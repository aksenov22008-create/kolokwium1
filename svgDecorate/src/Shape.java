public interface Shape {

    /*
     * interface
     * задає методи для класів.
     */

    BoundingBox boundingBox();

    String toSvg();
}