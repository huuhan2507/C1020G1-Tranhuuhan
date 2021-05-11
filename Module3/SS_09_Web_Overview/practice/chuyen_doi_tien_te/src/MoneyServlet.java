import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MoneyServlet",urlPatterns = "/money")
public class MoneyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        float rate =  Float.parseFloat(request.getParameter( "rate" ) );
        float usd =  Float.parseFloat(request.getParameter( "USD" ) );
        writer.println( "<html>" );
        float vnd = usd * rate;
        writer.println( "<p>"+rate+"</p>" );
        writer.println( "<p>"+usd+"</p>" );
        writer.println( "<p>"+vnd+"</p>" );
        writer.println( "</html>" );
    }
}
