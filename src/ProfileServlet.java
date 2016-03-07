import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -4845548454711575585L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("userName");
			out.print("Hello, " + name + "! Welcome to your Profile! <a href=\"LogoutServlet\">Logout</a>");
		} else {
			out.print("<span class=\"error\">Please login first</span>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}