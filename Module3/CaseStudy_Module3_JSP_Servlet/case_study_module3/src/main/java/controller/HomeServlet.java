package controller;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet",urlPatterns = {"","/homeServlet"})
public class HomeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose = request.getParameter( "choose" );
        if(choose == null){
            choose = "";
        }
        switch (choose){
            case "employee":
                request.setAttribute( "listEmployee",employeeService.showEmployee() );
                request.getRequestDispatcher( "employee/employee.jsp" ).forward( request,response );
                break;
            case "customer":
                break;
            default:
                response.sendRedirect( "home.jsp" );
        }
    }
}
