
package wyjatki2;


public class BadIdException extends RuntimeException {

   
    public BadIdException(String text,int number) {
        super(text+" ERROR EXCEPTION "+number);
        
       
    }
    

}
