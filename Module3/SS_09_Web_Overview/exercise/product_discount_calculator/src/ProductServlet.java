import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int price = Integer.parseInt( request.getParameter( "price" ) );
        double percent = Float.parseFloat( request.getParameter( "percent" ) );
        double discount_amount = price * percent * 0.01;
        double discount_price = price - discount_amount;
        request.setAttribute( "discount_amount", discount_amount );
        request.setAttribute( "discount_price", discount_price );
        request.getRequestDispatcher( "index.jsp" ).forward( request,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
