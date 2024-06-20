package br.com.hexa.infra.config.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
//        ExceptionResponse errorDetails = new ExceptionResponse()
//                .setTimeStamp(LocalDateTime.now())
//                .setMensagem(ex.getMessage())
//                .setMensagemDetalhada(request.getDescription(false))
//                .setStatus(HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
//        ExceptionResponse errorDetails = new ExceptionResponse()
//                .setTimeStamp(LocalDateTime.now())
//                .setMensagem(ex.getMessage())
//                .setMensagemDetalhada(request.getDescription(false))
//                .setStatus(HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ExceptionResponse errorDetails = new ExceptionResponse()
//                .setTimeStamp(LocalDateTime.now())
//                .setMensagem(ex.getMessage())
//                .setMensagemDetalhada(request.getDescription(false))
//                .setCodigoErro(ex.getStatusCode().toString())
//                .setStatus(HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
//    }
}
