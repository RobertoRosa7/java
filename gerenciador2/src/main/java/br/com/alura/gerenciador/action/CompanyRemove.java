package br.com.alura.gerenciador.action;

import br.com.alura.gerenciador.model.DataBase;

import javax.servlet.http.HttpServletRequest;

public class CompanyRemove implements Action {

    public String execution(HttpServletRequest request) {
        String paramsId = request.getParameter("id");
        Integer id = Integer.valueOf(paramsId);

        DataBase database = new DataBase();
        database.companyRemove(id);

        return "redirect:entrance?action=company-list";
    }
}
