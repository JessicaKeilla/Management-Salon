package com.beautysalon.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Erro 404 - Página não encontrada
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("errorCode", "404");
        model.addAttribute("errorMessage", "Página não encontrada");
        return "error/customError";
    }

    // Erro geral - Exceções não tratadas
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorCode", "500");
        model.addAttribute("errorMessage", "Ocorreu um erro inesperado.");
        return "error/customError";
    }
}
