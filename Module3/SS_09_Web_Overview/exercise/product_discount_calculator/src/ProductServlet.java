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
        PrintWriter writer = response.getWriter();
        String product_name = request.getParameter( "name" );
        int price = Integer.parseInt( request.getParameter( "price" ) );
        double percent = Float.parseFloat( request.getParameter( "percent" ) );
        double discount_amount = price * percent * 0.01;
        double discount_price = price - discount_amount;
        if (percent>0&&percent<=100 && price > 0){
            writer.println( "<html>" );
            writer.println( "<h3> Product name : " + product_name + "</h3>" );
            writer.println( "<h3> Price: " + price + "</h3>" );
            writer.println( "<h3> Discount percent: " + percent+ "</h3>" );
            writer.println( "<hr>" );
            writer.println( "<h3> Discount amount: " + discount_amount + "</h3>" );
            writer.println( "<h3> Discount price: " + discount_price + "</h3>" );
            writer.println( "</html>" );
        }else {
            writer.println( "<h1> Error </h1>" );
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
