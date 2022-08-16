package br.com.alura.gerenciador.middlewares;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MiddlewareAuth implements Filter {
    private boolean isProtected = false;

    private boolean userNotLogged(HttpSession session) {
        return session.getAttribute("userLogged") == null && this.isProtected;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String paramAction = httpRequest.getParameter("action");
        HttpSession session = httpRequest.getSession();

        this.isProtected = !(paramAction.equals("company-login") || paramAction.equals("company-login-form"));

        if (this.userNotLogged(session)) {
//            this.routerRedirect(response, "redirect:entrance?action=company-login-form");
            httpResponse.sendRedirect("entrance?action=company-login-form");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
