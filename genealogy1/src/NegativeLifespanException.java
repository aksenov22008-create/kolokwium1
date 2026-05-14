public class NegativeLifespanException extends Exception{

    /*
     * super(...)
     * викликає конструктор Exception.
     */
    public NegativeLifespanException (Person person){
        super(person.negativeLifespanExceptionMessege());
    }
}