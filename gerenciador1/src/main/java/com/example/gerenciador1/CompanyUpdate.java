package com.example.gerenciador1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyUpdate", value = "/company-update")
public class CompanyUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramsId = request.getParameter("id");
        Integer id = Integer.valueOf(paramsId);

        DataBase dataBase = new DataBase();
        Company company = dataBase.findId(id);

        RequestDispatcher rd = request.getRequestDispatcher("company-update.jsp");
        request.setAttribute("company", company);
        rd.forward(request, response);
    }
}
