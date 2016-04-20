package br.com.altamira.wbccad;

import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class DefaultErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        System.out.println(String.format("Error in listener: %s", t));
    }
}
