package br.com.alura.gerenciador.action;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.DataBase;

import javax.servlet.http.HttpServletRequest;

public class CompanyUpdate implements Action {
    public String execution(HttpServletRequest request) {
        String paramsId = request.getParameter("id");
        Integer id = Integer.valueOf(paramsId);

        DataBase dataBase = new DataBase();
        Company company = dataBase.findId(id);
        request.setAttribute("company", company);

        return "forward:company-update.jsp";
    }
}
