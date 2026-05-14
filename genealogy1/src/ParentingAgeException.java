public class ParentingAgeException extends Exception {

    public ParentingAgeException(
            Person parent,
            Person child
    ){

        /*
         * String.format(...)
         * вставляє значення у текст.
         */
        super(String.format(
                "Podejrzany rodzic: %s dla dziecka %s",
                parent.name(),
                child.name()
        ));
    }

}