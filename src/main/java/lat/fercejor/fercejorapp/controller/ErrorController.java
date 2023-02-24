package lat.fercejor.fercejorapp.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lat.fercejor.fercejorapp.config.CustomException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = { Exception.class })
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "Ha ocurrido un error en la aplicación: " + e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = { AccessDeniedException.class })
    public ModelAndView handleAccessDeniedException(AccessDeniedException e) {
        ModelAndView modelAndView = new ModelAndView("403");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }

    // Error si se intenta acceder a una página sin estar logueado
    @ExceptionHandler(value = { AuthenticationException.class })
    public ModelAndView handleAuthenticationException(AuthenticationException e) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(value = { CustomException.class })
    public ModelAndView handleCustomException(CustomException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }

}
