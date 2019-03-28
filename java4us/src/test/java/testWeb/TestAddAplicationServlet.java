package testWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import domain.ConferenceApplication;
import repositories.ConferenceApplicationRepository;
import web.AddAplicationServlet;

//@RunWith(MockitoJUnitRunner.class);
public class TestAddAplicationServlet extends Mockito {
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Spy
	ConferenceApplicationRepository repository = mock (ConferenceApplicationRepository.class);
	
	@InjectMocks
	AddAplicationServlet servlet;
	
	@Test
	public void servlet_should_write_info_about_applicant_into_session()
			throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		servlet.doGet(request, response);
		verify(session).setAttribute(eq("conf"), Mockito.any(ConferenceApplication.class));
	}
	
	@Test
	public void servlet_should_add_form_data_into_repository()
			throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		servlet.doGet(request, response);
		verify(repository).add(Mockito.any(ConferenceApplication.class));
	}
	
	@Test
	public void servlet_should_properly_redirect_user()
			throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		servlet.doGet(request, response);
		verify(response).sendRedirect("success.jsp");
	}

}