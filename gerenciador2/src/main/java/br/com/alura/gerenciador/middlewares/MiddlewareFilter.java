package br.com.alura.gerenciador.middlewares;


import javax.servlet.*;
import java.io.IOException;

public class MiddlewareFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();

        // action
        String action = request.getParameter("action");
        chain.doFilter(request, response);

        long after = System.currentTimeMillis();
        System.out.println("time execution from: " + action + " " + (after - before) + "ms");
    }

    @Override
    public void destroy() {

    }
}
