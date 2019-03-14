package testKalkulatorKredytowy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import kalkulatorKredytowy.KalkulatorKredytowy;

public class TestKalkulatorKredytowy extends Mockito {
	
	@Test
	public void kalkulator_should_not_count_if_wnioskowanaKwotaKredytu_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("wnioskowanaKwotaKredytu")).thenReturn("");
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}

}
