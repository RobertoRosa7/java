package br.com.alura.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CompanyLogout implements Action {
    public String execution(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:entrance?action=company-login-form";
    }
}
