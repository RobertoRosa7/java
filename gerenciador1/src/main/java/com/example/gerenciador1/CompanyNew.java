package com.example.gerenciador1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


@WebServlet(name = "CompanyNew", value = "/company-new")
public class CompanyNew extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyGeneral companyGeneral = new CompanyGeneral(
                request.getParameter("companyName"),
                request.getParameter("companyDate"));
        Date date;

        try {
            date = companyGeneral.getDate();
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company company = new Company();
        company.setName(companyGeneral.getName());
        company.setDate(date);

        DataBase database = new DataBase();
        database.add(company);

        // call JPS
//        RequestDispatcher rd = request.getRequestDispatcher("/company-list");
//        request.setAttribute("companyName", company.getName());
//        rd.forward(request, response);

        request.setAttribute("companyName", company.getName());
        response.sendRedirect("company-list");
    }

}
