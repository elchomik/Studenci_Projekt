
package wyjatki2;
public class BadNameException extends RuntimeException {

    public BadNameException(){}
    
    public BadNameException(String format)
    {
       super(format);
    }
    
}
