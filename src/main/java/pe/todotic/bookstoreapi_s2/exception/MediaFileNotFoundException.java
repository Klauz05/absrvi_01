package pe.todotic.bookstoreapi_s2.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MediaFileNotFoundException extends RuntimeException{
  public MediaFileNotFoundException(String message){
    super(message);
  }
}
