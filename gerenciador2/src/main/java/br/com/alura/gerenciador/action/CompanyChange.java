package br.com.alura.gerenciador.action;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.CompanyGeneral;
import br.com.alura.gerenciador.model.DataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

public class CompanyChange implements Action {

    public String execution(HttpServletRequest request) throws ServletException {
        CompanyGeneral companyGeneral = new CompanyGeneral(
                request.getParameter("companyName"),
                request.getParameter("companyDate"),
                request.getParameter("companyId")
        );
        Date date;

        try {
            date = companyGeneral.getDate();
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        DataBase dataBase = new DataBase();
        Company company = dataBase.findId(companyGeneral.getId());
        company.setName(companyGeneral.getName());
        company.setDate(date);

        return "redirect:entrance?action=company-list";
    }
}
