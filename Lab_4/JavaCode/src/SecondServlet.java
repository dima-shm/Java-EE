import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class SecondServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        int hour = date.getHours();
        RequestDispatcher requestDispatcher = null;

        System.out.println("_GET_ELSE_");
        if(hour > 0 && hour <= 5)
            requestDispatcher = request.getRequestDispatcher("night.jsp");
        else if(hour > 5 && hour <= 12)
            requestDispatcher = request.getRequestDispatcher("morning.jsp");
        else if (hour > 12 && hour <= 17)
            requestDispatcher = request.getRequestDispatcher("afternoon.jsp");
        else
            requestDispatcher = request.getRequestDispatcher("evening.jsp");
        requestDispatcher.forward(request, response);
    }
}
