package com.example.gerenciador1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompanyRemove", value = "/company-remove")
public class CompanyRemove extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramsId = req.getParameter("id");
        Integer id = Integer.valueOf(paramsId);

        DataBase database = new DataBase();
        database.companyRemove(id);

        resp.sendRedirect("company-list");
    }
}
