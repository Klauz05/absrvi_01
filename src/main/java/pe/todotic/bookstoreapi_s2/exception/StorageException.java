package pe.todotic.bookstoreapi_s2.exception;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StorageException extends RuntimeException{
  public StorageException(String message){
    super(message);
  }
}
