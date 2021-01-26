import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double operaFirst = Double.parseDouble( request.getParameter( "operaFirst" ) );
        double operaSecond = Double.parseDouble( request.getParameter( "operaSecond" ) );
        String operator = request.getParameter( "operator" );
        double result=0;
        switch (operator){
            case "Addition":
                result= operaFirst + operaSecond;
                break;
            case "Subtraction":
                result= operaFirst - operaSecond;
                break;
            case "Multiplication":
                result= operaFirst * operaSecond;
                break;
            case "Division":
                result = operaFirst / operaSecond;
                break;
            default:
        }
        request.setAttribute( "result",result );
        request.getRequestDispatcher( "index.jsp" ).forward( request,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
