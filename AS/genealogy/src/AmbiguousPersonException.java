public class AmbiguousPersonException extends RuntimeException{
    public AmbiguousPersonException(Person p){
        super("Osoba juz istnieje: " + p);
    }
}
