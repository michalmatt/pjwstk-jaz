package kalkulatorKredytowy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.math3.util.Precision;

@WebServlet("/kalkulatorkredytowy")
public class KalkulatorKredytowy extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int LICZBA_RAT_W_ROKU = 12;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		if(request.getParameter("wnioskowanaKwotaKredytu") == null || request.getParameter("wnioskowanaKwotaKredytu").equals("")) {
			response.sendRedirect("/");
		}
		if(request.getParameter("iloscRat") == null || request.getParameter("iloscRat").equals("")) {
			response.sendRedirect("/");
		}
		if(request.getParameter("oprocentowanie") == null || request.getParameter("oprocentowanie").equals("")) {
			response.sendRedirect("/");
		}
		if(request.getParameter("oplataStala") == null || request.getParameter("oplataStala").equals("")) {
			response.sendRedirect("/");
		}
		
		double wnioskowanaKwotaKredytu = Double.parseDouble(request.getParameter("wnioskowanaKwotaKredytu"));
		int iloscRat = Integer.parseInt(request.getParameter("iloscRat"));
		double oprocentowanie = Double.parseDouble(request.getParameter("oprocentowanie"))/100;
		double oplataStala = Double.parseDouble(request.getParameter("oplataStala"));
		String rodzajRat = request.getParameter("rodzajRat");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			.append("<html>\r\n")
			.append("<head>\r\n")
			.append("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"ISO-8859-1\">\r\n")
			.append("<title>Kalukator kredytowy</title>\r\n")
			.append("</head>\r\n")
			.append("<body>\r\n")
				.append("<table>\r\n")
					.append("<tr>\r\n")
						.append("<th>Nr raty</th>\r\n")
						.append("<th>Kwota kapitalu</th>\r\n")
						.append("<th>Kwota odsetek</th>\r\n")
						.append("<th>Oplaty stale</th>\r\n")
						.append("<th>Calkowita kwota raty</th>\r\n")
					.append("</tr>\r\n");
					double oplatyPerRata = Precision.round(oplataStala/iloscRat, 2);					
					if(rodzajRat.equals("raty_malejace")) {
						for (int id = 1, i = 0; id <= iloscRat; id++, i++) {
							double kapitalowaCzescRaty = Precision.round(wnioskowanaKwotaKredytu/iloscRat, 2);
							double odsetkowaCzescRaty = Precision.round((wnioskowanaKwotaKredytu - i * kapitalowaCzescRaty) * oprocentowanie/LICZBA_RAT_W_ROKU, 2);
							double calkowitaKwotaRaty = Precision.round(kapitalowaCzescRaty + oplatyPerRata + odsetkowaCzescRaty, 2);
							writer.append("<tr>\r\n")
								.append("<td>" + id + "</td>\r\n")
								.append("<td>" + kapitalowaCzescRaty + "</td>\r\n")
								.append("<td>" + odsetkowaCzescRaty + "</td>\r\n")
								.append("<td>" + oplatyPerRata + "</td>\r\n")
								.append("<td>" + calkowitaKwotaRaty + "</td>\r\n")
							.append("</tr>\r\n");
						}
					}
					else if (rodzajRat.equals("stala_wysokosc_rat")) {
						for (int id = 1, i = 0; id <= iloscRat; id++, i++) {
							double wspolczynnik = 1+(oprocentowanie/LICZBA_RAT_W_ROKU);
							//double wysokoscRatyStalej = Precision.round(wnioskowanaKwotaKredytu * Math.pow(wspolczynnik, iloscRat) * (wspolczynnik - 1) / (Math.pow(wspolczynnik, iloscRat)-1), 2);
							double kapitalowaCzescRaty = Precision.round(wnioskowanaKwotaKredytu * oprocentowanie/LICZBA_RAT_W_ROKU * Math.pow(wspolczynnik, i) / (Math.pow(wspolczynnik, iloscRat) - 1), 2);
							double odsetkowaCzescRaty = Precision.round(wnioskowanaKwotaKredytu * oprocentowanie/LICZBA_RAT_W_ROKU * (Math.pow(wspolczynnik, iloscRat) - Math.pow(wspolczynnik, i)) / (Math.pow(wspolczynnik, iloscRat) - 1), 2);
							//double odsetkowaCzescRaty = Precision.round(wysokoscRatyStalej - kapitalowaCzescRaty, 2);
							double calkowitaKwotaRaty = Precision.round(kapitalowaCzescRaty + oplatyPerRata + odsetkowaCzescRaty, 2);
							writer.append("<tr>\r\n")
								.append("<td>" + id + "</td>\r\n")
								.append("<td>" + kapitalowaCzescRaty + "</td>\r\n")
								.append("<td>" + odsetkowaCzescRaty + "</td>\r\n")
								.append("<td>" + oplatyPerRata + "</td>\r\n")
								.append("<td>" + calkowitaKwotaRaty + "</td>\r\n")
							.append("</tr>\r\n");
						}
					}
				writer.append("</table>\r\n")
			.append("</body>\r\n")
			.append("</html>\r\n");
	}
}