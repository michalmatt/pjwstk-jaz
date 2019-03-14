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
	public void kalkulator_should_not_count_if_wnioskowanaKwotaKredytu_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("wnioskowanaKwotaKredytu")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
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
	
	@Test
	public void kalkulator_should_not_count_if_iloscRat_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("iloscRat")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_iloscRat_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("iloscRat")).thenReturn("");
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_oprocentowanie_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("oprocentowanie")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_oprocentowanie_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("oprocentowanie")).thenReturn("");
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_oplataStala_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("oplataStala")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_oplataStala_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("oplataStala")).thenReturn("");
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_rodzajRat_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("rodzajRat")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}
	
	@Test
	public void kalkulator_should_not_count_if_rodzajRat_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		
		when(request.getParameter("rodzajRat")).thenReturn("");
		when(response.getWriter()).thenReturn(writer);
		
		new KalkulatorKredytowy().doPost(request, response);
		verify(response).sendRedirect("/");
	}

}
