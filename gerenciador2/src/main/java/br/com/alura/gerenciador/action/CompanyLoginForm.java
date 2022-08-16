package br.com.alura.gerenciador.action;

import javax.servlet.http.HttpServletRequest;

public class CompanyLoginForm implements Action {

    public String execution(HttpServletRequest request) {
        return "forward:company-login.jsp";
    }
}
