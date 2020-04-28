package lv.javaguru.finalwork.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
public class EmptyListException extends RuntimeException {
}