

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		
		System.out.println("INSIDE FILTER DO FILTER WITH URL " + uri);
		
		HttpSession session = req.getSession(false);
		
		boolean loggedIn = session != null && session.getAttribute("customerid") != null;
		
		if(!loggedIn && !(uri.endsWith("CustomerLogin.jsp") || uri.endsWith("/") || uri.endsWith("/AdminLogin.jsp") || uri.endsWith("LoginController") || uri.endsWith("main.css"))) {
			System.out.println("INSIDE NULL SESSION");
			String message = "Please Login!";
			res.sendRedirect("CustomerLogin.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			
		}
		else {
			System.out.println("SESSION IS " + session);
			chain.doFilter(req, res);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
