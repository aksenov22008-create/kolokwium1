import java.util.Locale;

public class TransformationDecorator
        extends ShapeDecorator{

    // рядок трансформацій
    private String transformation;

    public TransformationDecorator(
            Shape decoratorShape,
            Vec2 translation,
            double rotate,
            Vec2 scal) {

        super(decoratorShape);

        /*
         * Builder pattern
         * поетапне створення об'єкта.
         */
        Builder builder = new Builder()
                .translation(translation)
                .rotation(rotate)
                .scale(scal);

        this.transformation = builder.build();
    }

    public String toSvg() {

        return this.decoratorShape.toSvg().replace("/>",
                String.format(
                        "transform=\"%s\"/>",
                        transformation
                ));
    }

    public static class Builder{

        private Vec2 translation;
        private double rotation;
        private Vec2 scale;

        /*
         * return this
         * дозволяє викликати
         * методи ланцюжком.
         */
        public Builder rotation(double rotation) {
            this.rotation = rotation;
            return this;
        }

        public Builder translation(Vec2 translation) {
            this.translation = translation;
            return this;
        }

        public Builder scale(Vec2 scale) {
            this.scale = scale;
            return this;
        }

        public String build(){

            /*
             * StringBuilder
             * швидке створення тексту.
             */
            StringBuilder bb =
                    new StringBuilder();

            if(translation!=null){

                bb.append(String.format(
                        Locale.ENGLISH,
                        "translate(%f,%f) ",
                        translation.x(),
                        translation.y()
                ));
            }

            if(rotation!=0){

                bb.append(String.format(
                        Locale.ENGLISH,
                        "rotate(%f) ",
                        rotation
                ));
            }

            if(scale!=null){

                bb.append(String.format(
                        Locale.ENGLISH,
                        "scale(%f,%f) ",
                        scale.x(),
                        scale.y()
                ));
            }

            return bb.toString();
        }
    }
}