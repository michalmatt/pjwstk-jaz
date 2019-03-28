package web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import repositories.DummyConferenceApplicationRepository;

@WebFilter(urlPatterns = "/", servletNames = "AddApplicantServlet")
public class RegistrationClosedFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(new DummyConferenceApplicationRepository().count()>2) {
			response.getWriter().println("Rejestracja na konferencje zakonczyla sie.");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
