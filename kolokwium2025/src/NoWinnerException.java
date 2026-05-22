// Виняток якщо немає переможця
public class NoWinnerException
        extends Exception{

    public NoWinnerException(){

        super("No winner");
    }

}