package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.action.Action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ControllerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String paramAction = httpRequest.getParameter("action");
        String nameClass = "br.com.alura.gerenciador.action." + this.formatParamsString(paramAction);
        String routeName = "";

        try {
            Class<?> classes = Class.forName(nameClass); // load class with name string dynamic
            Action action = (Action) classes.newInstance();
            routeName = action.execution(httpRequest);
        } catch (ClassNotFoundException | RuntimeException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }

        if (routeName.equals("")) {
            throw new ServletException("No Router found");
        }

        String[] type = routeName.split(":");
        if (type[0].equals("forward")) {
            this.routerForward(httpRequest, httpResponse, type[1]);
        } else {
            this.routerRedirect(httpResponse, type[1]);
        }
    }

    @Override
    public void destroy() {

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
        return Arrays.stream(textList).map((text) -> text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase()).collect(Collectors.joining(""));
    }
}
