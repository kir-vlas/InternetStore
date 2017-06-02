package org.nc.edu.internet_store.mvc.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Error with confirmation order")
public class OrderConfirmationException extends RuntimeException {


    public OrderConfirmationException (){
        super();
        throw new InternalError();
    }

    public OrderConfirmationException(String s){
        super(s);
    }

    public OrderConfirmationException(Throwable cause){
        super(cause);
    }

    public OrderConfirmationException(String path, String reason){
        super(path + ((reason == null)
                ? ""
                : " (" + reason + ")"));
    }
}
