import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ggg extends HttpServlet implements Servlet {
protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
throws ServletException, IOException {
String parm1 = rq.getParameter("page"); // 1
String parm2 = rq.getParameter("name"); // 2
System.out.println("Ggg:doGet:page=" + parm1); // 3
System.out.println("Ggg:doGet:name=" + parm2); // 4
rs.setContentType("text/html"); // 5
PrintWriter pw = rs.getWriter(); // 6
pw.println("<html><body>" // 7
+"Hello from Servlet" // 8
+"<br>Ggg:doGet: page=" + parm1 // 9
+"<br>Ggg:doGet: name=" + parm2 // 10
+"<br>Ggg:getRemoteHost: "+rq.getRemoteHost() // 11
+"<br>Ggg:getServletPath: "+rq.getServletPath() // 12
+"<br>Ggg:getServerName: "+rq.getServerName() // 13
+"<br>Ggg:rq.getContextPath: "+rq.getContextPath() // 14
+"<br>Ggg:getServletName: "+this.getServletName() // 15
+"</body></html>"); // 16
pw.close(); // 17
}
}