package web.filter;

import java.io.IOException;
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

@WebFilter("/register")
public class RegisterUserFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		if(session.getAttribute("conf") != null) {
			httpResponse.getWriter().println("Your account has been already registered. Please login now.");
			return;
		}
		else if (httpRequest.getParameter("password").equals(httpRequest.getParameter("confirmpassword")) == false) {
			httpResponse.getWriter().println("'Password' & 'Confirm Password' fields does not match. Please try again.");
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
	}

}