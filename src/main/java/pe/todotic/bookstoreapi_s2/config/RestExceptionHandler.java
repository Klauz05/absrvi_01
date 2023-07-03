package pe.todotic.bookstoreapi_s2.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.todotic.bookstoreapi_s2.exception.BadRequestException;
import pe.todotic.bookstoreapi_s2.exception.MediaFileNotFoundException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class RestExceptionHandler {
  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ProblemDetail handleValidationError(MethodArgumentNotValidException exception) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Unprocessable Entity");
    problemDetail.setType(URI.create("https://docs.todotic.pe/errors/unprocessable-entity"));
    problemDetail.setDetail("The entity can't processed because it has errors");
    List<FieldError> fieldErrors = exception.getFieldErrors();
    List<String> errors = new ArrayList<>();
    for (FieldError fe : fieldErrors) {
      String message = messageSource.getMessage(fe, Locale.getDefault());
      errors.add(message);
    }
    problemDetail.setProperty("errors", errors);
    return problemDetail;
  }

  @ExceptionHandler(BadRequestException.class)
  ProblemDetail handleBadRequestException(BadRequestException exception) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle("Unprocessable Entity");
    problemDetail.setType(URI.create("https://docs.todotic.pe/errors/unprocessable-entity"));
    problemDetail.setDetail(exception.getMessage());
    return problemDetail;
  }

  @ExceptionHandler(EntityNotFoundException.class)
  ProblemDetail handleEntityNotFoundException(EntityNotFoundException exception) {
    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    problemDetail.setTitle("Not Found");
    problemDetail.setType(URI.create("https://docs.todotic.pe/errors/not-found"));
    problemDetail.setDetail(exception.getMessage());
    return problemDetail;
  }
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(MediaFileNotFoundException.class)
  void handleMediaFileNotFoundException() {}
}
