package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet(name = "Entrance", value = "/entrance")
public class Entrance extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramAction = request.getParameter("action");
        String routeName = "";
        String nameClass = "br.com.alura.gerenciador.action." + this.formatParamsString(paramAction);

        try {
            Class<?> classes = Class.forName(nameClass); // load class with name string dynamic
            Action action = (Action) classes.newInstance();
            routeName = action.execution(request);
        } catch (ClassNotFoundException | RuntimeException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }

        if (routeName.equals("")) {
            throw new ServletException("No Router found");
        }

        String[] type = routeName.split(":");
        if (type[0].equals("forward")) {
            this.routerForward(request, response, type[1]);
        } else {
            this.routerRedirect(response, type[1]);
        }
    }

    private void routerForward(HttpServletRequest request, HttpServletResponse response, String route) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + route);
        rd.forward(request, response);
    }

    private void routerRedirect(HttpServletResponse response, String route) throws IOException {
        response.sendRedirect(route);
    }

    private String formatParamsString(String params) {
        String[] textList = params.split("-");
        return Arrays.stream(textList)
                .map((text) -> text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase())
                .collect(Collectors.joining(""));
    }

}