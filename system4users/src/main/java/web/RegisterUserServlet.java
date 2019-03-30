package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import repositories.DummyUserRepository;
import repositories.UserRepository;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private User retriveUserRegistrationRequest(HttpServletRequest request) {
		User result = new User();
		result.setName(request.getParameter("name"));
		result.setPassword(request.getParameter("password"));
		result.setEmail(request.getParameter("email"));
		return result;
	}
	
	private UserRepository repository;
	
	public void init (ServletConfig config) throws ServletException {
		repository = new DummyUserRepository();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = retriveUserRegistrationRequest(request);
		
		session.setAttribute("conf", user);
		
		repository.add(user);
		response.sendRedirect("registrationSuccess.jsp");
		
	}

}
