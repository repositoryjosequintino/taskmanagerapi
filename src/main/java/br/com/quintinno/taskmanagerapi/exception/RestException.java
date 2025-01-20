package br.com.quintinno.taskmanagerapi.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.quintinno.taskmanagerapi.transfer.RestExceptionTransfer;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestExceptionTransfer> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        RestExceptionTransfer restExceptionTransfer = new RestExceptionTransfer();
            restExceptionTransfer.setStatus(HttpStatus.BAD_REQUEST.toString());
            restExceptionTransfer.setMensagem("Erro de validação");
            List<String> erroList = getErroList(methodArgumentNotValidException);
            restExceptionTransfer.setErrorList(erroList);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restExceptionTransfer);
    }

    private List<String> getErroList(MethodArgumentNotValidException methodArgumentNotValidException) {
        return methodArgumentNotValidException.getBindingResult()
                              .getFieldErrors()
                              .stream()
                              .map(error -> error.getField() + ": " + error.getDefaultMessage())
                              .collect(Collectors.toList());
    }

}
