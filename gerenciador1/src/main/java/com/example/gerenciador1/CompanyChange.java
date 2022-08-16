package com.example.gerenciador1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "CompanyChange", value = "/company-change")
public class CompanyChange extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        response.sendRedirect("company-list");
    }
}
