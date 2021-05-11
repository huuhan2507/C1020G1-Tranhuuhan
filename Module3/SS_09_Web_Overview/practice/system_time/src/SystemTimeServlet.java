import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SystemTimeServlet",urlPatterns = "/index")
public class SystemTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter =  response.getWriter();
        printWriter.println( "<html>" );
        printWriter.println( "<body>" );
        Date today = new Date();
        printWriter.println( "<h1>Hello World</h1>" );
        printWriter.println( "<h1>"+today+"</h1>" );
        printWriter.println( "</body>" );
        printWriter.println( "</html>" );





    }
}
