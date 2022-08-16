package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.model.Company;
import br.com.alura.gerenciador.model.DataBase;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCompanyServiceList", value = "/services-companies")
public class ServletCompanyServiceList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies = new DataBase().getCompanies();

        Gson gson = new Gson();
        String json = gson.toJson(companies);
        response.setContentType("application/json");
        response.getWriter().println(json);

//        XStream xStream = new XStream();
//        String xml = xStream.toXML(companies);
//        response.setContentType("application/xml");
//        response.getWriter().print(xml);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
