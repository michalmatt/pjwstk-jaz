package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ConferenceApplication;
import repositories.ConferenceApplicationRepository;
import repositories.DummyConferenceApplicationRepository;

@WebServlet("/add")
public class AddAplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ConferenceApplication retriveApplicationFromRequest(HttpServletRequest request) {
		ConferenceApplication result = new ConferenceApplication();
		result.setName(request.getParameter("name"));
		result.setSurname(request.getParameter("surname"));
		result.setAdvertisement(request.getParameter("info"));
		result.setEmail(request.getParameter("email"));
		result.setEmployment(request.getParameter("employment"));
		return result;
	}
	
	private ConferenceApplicationRepository repository;
	
	public void init (ServletConfig config) throws ServletException {
		repository = new DummyConferenceApplicationRepository();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ConferenceApplication application = retriveApplicationFromRequest(request);
		//ConferenceApplicationRepository repository = new DummyConferenceApplicationRepository();
		
		session.setAttribute("conf", application);
		
		repository.add(application);
		response.sendRedirect("success.jsp");
		
	}

}
