import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ttt extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Ttt() {
        super();
    }
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
    System.out.println("Ttt:service:doPost");
	
    PrintWriter pw=rs.getWriter();
	pw.println("<html><body><br>Surname = "+
			rq.getParameter("surname")+"<br>Lastname = "+
			rq.getParameter("lastname")+"<br>Sex = " +
			rq.getParameter("sex") + "</body></html>");
	pw.close();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}
}