import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList= new ArrayList<>();
        customerList.add( new Customer( "Hân","25/07/2002","Phú Yên", "fileimage/png1.jpg" ) );
        customerList.add( new Customer( "Phin","11/04/2006","Huế", "fileimage/png2.jpg" ) );
        customerList.add( new Customer( "Hiên","12/12/2001","Đà Nẵng", "fileimage/png3.jpg" ) );

        request.setAttribute( "list",customerList );
        request.getRequestDispatcher( "customer.jsp" ).forward( request,response );
    }
}
