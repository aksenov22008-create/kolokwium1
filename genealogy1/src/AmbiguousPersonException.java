public class AmbiguousPersonException extends Exception{

    // final -> значення не змінюється
    private final Person person1;
    private final Person person2;

    public AmbiguousPersonException(Person person1 , Person person2){
        this.person1=person1;
        this.person2=person2;
    }

    @Override
    public String getMessage(){

        /*
         * String.format(...)
         * вставляє значення у текст.
         */
        return String.format("Konflik nazw: %s vs %s",person1,person2);
    }
}