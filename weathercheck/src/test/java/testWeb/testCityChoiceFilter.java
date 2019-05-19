package testWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import filters.CityChoiceFilter;

public class testCityChoiceFilter extends Mockito {
	
	@Test
	public void CityChoiceServletShouldNotBeCalledIfcityNameNotOnTheList() throws IOException, ServletException {
		ServletRequest request = mock(ServletRequest.class);
		ServletResponse response = mock(ServletResponse.class);
		FilterChain chain = mock(FilterChain.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("cityName")).thenReturn("0");
		when(response.getWriter()).thenReturn(writer);
		
		new CityChoiceFilter().doFilter(request, response, chain);
		verify(response).getWriter();
		verify(writer).println("Error: city name not on the list.");
	}

}
