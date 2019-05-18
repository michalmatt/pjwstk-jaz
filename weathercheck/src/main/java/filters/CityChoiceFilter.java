package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/weathercheck")
public class CityChoiceFilter implements Filter {

	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		int cityId = Integer.parseInt(request.getParameter("cityName"));
		if (cityId != 6695624 && cityId != 3099434 && cityId != 3094802
				&& cityId != 3081368 && cityId != 3088171
				&& cityId != 3093133 && cityId != 3096472) {
			response.getWriter().println("Error: city name not on the list.");
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
