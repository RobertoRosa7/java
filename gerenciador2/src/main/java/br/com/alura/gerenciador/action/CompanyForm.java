package br.com.alura.gerenciador.action;

import javax.servlet.http.HttpServletRequest;

public class CompanyForm implements Action {

    public String execution(HttpServletRequest request) {
        return "forward:company-form.jsp";
    }

}
