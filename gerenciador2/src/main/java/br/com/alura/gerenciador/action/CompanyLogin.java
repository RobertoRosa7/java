package br.com.alura.gerenciador.action;

import br.com.alura.gerenciador.model.DataBase;
import br.com.alura.gerenciador.model.User;

import javax.servlet.http.HttpServletRequest;

public class CompanyLogin implements Action {

    public String execution(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DataBase database = new DataBase();
        User user = database.existAuth(login, password);

        if (user == null) {
            System.out.println("User not exists");
            return "redirect:entrance?action=company-login-form";
        }

        request.setAttribute("userLogged", user);
        return "redirect:entrance?action=company-list";
    }
}
