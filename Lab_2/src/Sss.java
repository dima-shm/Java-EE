import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Sss extends HttpServlet implements Servlet {
	
	public Sss() {
		super();
		System.out.println("Sss:constructor");
	}
	
	public void init(ServletConfig sc) throws ServletException {
		super.init();
		System.out.println("Sss:init");
	}
	
	public void destroy() {
		super.destroy();
		System.out.println("Sss:destroy");
	}
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String parm1 = rq.getParameter("page");
		String parm2 = rq.getParameter("name");
		System.out.println("Sss:doGet:page = " + parm1);
		System.out.println("Sss:doGet:name = " + parm2);

		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html>"
					+ "<body>"
						+ "<br>Sss:doGet:page =" + parm1
						+ "<br>Sss:doGet:name =" + parm2
						+ "<br>Sss:getRemoteHost: " + rq.getRemoteHost()
						+ "<br>Sss:getServletPath: " + rq.getServletPath()
						+ "<br>Sss:getServerName: " + rq.getServerName()
						+ "<br>Sss:rq.getContextPath: " + rq.getContextPath()
						+ "<br>Sss:rq.getRequestURI: " + rq.getRequestURI()
						+ "<br>Sss:rq.getRequestURL: " + rq.getRequestURL()
					+ "</body>"
				 + "</html>");
		pw.close();
	}
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String firstname = rq.getParameter("firstname");
		String lastname = rq.getParameter("lastname");
		String password = rq.getParameter("password");
		String sex = rq.getParameter("sex");
		String press = rq.getParameter("press");

		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html> "
					+ "<body> "
						+ "<br>Sss:doPost:firstname = " + firstname
						+ "<br>Sss:doPost:lastname = " + lastname
						+ "<br>Sss:doPost:password = " + password
						+ "<br>Sss:doPost:sex = " + sex
						+ "<br>Sss:doPost:press = " + press
					+ "</body>"
				 + "</html>");
		pw.close();
	}
	
	//protected void service(HttpServletRequest rq, HttpServletResponse rs)
	//throws ServletException, IOException {
	//}
}