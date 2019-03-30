package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private UserRepository repository;
	
	//public void init (ServletConfig config) throws ServletException {
	//	repository = new DummyUserRepository();
	//}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//User user = repository.getUserByName(request.getParameter("name"));
		
		//if (user != null && user.getPassword().equals(request.getParameter("password"))) {
		//	session.setAttribute("user", user);
		//	session.setAttribute("conf", null);
		//	response.sendRedirect("profile.jsp");
		//}
		//else {
		//	response.getWriter().println("Incorrect login or password. Please try again.");
		//}
		
	}

}
