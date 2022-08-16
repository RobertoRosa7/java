package com.example.gerenciador1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CompanyList", value = "/company-list")
public class CompanyList extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataBase database = new DataBase();
        List<Company> companies = database.getCompanies();
        request.setAttribute("companies", companies);

        RequestDispatcher rd = request.getRequestDispatcher("/company-list.jsp");
        rd.forward(request, response);
    }
}
