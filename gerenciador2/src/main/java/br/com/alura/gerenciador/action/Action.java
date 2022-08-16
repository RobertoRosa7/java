package br.com.alura.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
    String execution(HttpServletRequest request) throws ServletException;
}
