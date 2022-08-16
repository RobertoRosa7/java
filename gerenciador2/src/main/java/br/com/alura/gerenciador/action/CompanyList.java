package br.com.alura.gerenciador.action;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.DataBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CompanyList implements Action{

    public String execution(HttpServletRequest request) {
        DataBase database = new DataBase();
        List<Company> companies = database.getCompanies();
        request.setAttribute("companies", companies);

        return "forward:company-list.jsp";
    }
}
