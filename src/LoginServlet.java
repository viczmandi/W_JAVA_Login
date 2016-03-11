
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 9211568140687018262L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("userName");
		String password = request.getParameter("passwd");

		HttpSession session = request.getSession();
		if (name.equals("viczmandi") && password.equals("pwd123")) {
			if (session.getAttribute("userName") == null || !session.getAttribute("userName").equals(name)) {
				// out.print("Welcome " + name + "! <a
				// href=\"ProfileServlet\">Go to your profile</a>");
				session.setAttribute("userName", name);
				response.sendRedirect("ProfileServlet");
			} else if (session.getAttribute("userName") != null) {
				out.print(name + ", you are already logged in! <a href=\"ProfileServlet\">Go to your profile</a><hr>");
				request.getRequestDispatcher("index.html").include(request, response);
			}
		} else {
			out.print("<span class=\"error\">Bad username or password! Permission denied</span><hr>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}
