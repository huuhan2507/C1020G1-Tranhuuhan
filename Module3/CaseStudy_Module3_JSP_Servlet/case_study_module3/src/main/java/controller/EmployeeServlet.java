package controller;

import bean.employee.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")


public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        if (action.equals( "close" )) {
            homeEmployee( request, response );
        }
        int id = Integer.parseInt( request.getParameter( "id" ) );
        String name = request.getParameter( "name" );
        String birthday = request.getParameter( "birthday" );
        String cardId = request.getParameter( "cardId" );
        String salary = request.getParameter( "salary" );
        String phone = request.getParameter( "phone" );
        String email = request.getParameter( "email" );
        String address = request.getParameter( "address" );
        int positionId = Integer.parseInt( request.getParameter( "position" ) );
        int education_degree = Integer.parseInt( request.getParameter( "education" ) );
        int division = Integer.parseInt( request.getParameter( "division" ) );
        String userName = request.getParameter( "user" );
        Employee employee = new Employee( id, name, birthday, cardId, Double.parseDouble( salary ), phone, email, address,
                positionId, education_degree, division, userName );
        List<String> errEmployee = employeeService.checkValidateEmployee( phone, cardId, email, salary );
        switch (action) {
            case "create":
                if (employeeService.checkValidateEmployeeInService( phone, cardId, email, salary )) {
                    employeeService.addEmployee( employee );
                    homeEmployee( request, response );
                } else {
                    request.setAttribute( "employee", employee );
                    request.setAttribute( "errEmployee", errEmployee );
                    request.getRequestDispatcher( "employee/create_employee.jsp" ).forward( request, response );
                }
                break;
            case "update":
                if (employeeService.checkValidateEmployeeInService( phone, cardId, email, salary )) {
                    employeeService.editEmployee( employee );
                    homeEmployee( request, response );
                } else {
                    request.setAttribute( "employee", employee );
                    request.setAttribute( "errEmployee", errEmployee );
                    request.getRequestDispatcher( "employee/update_employee.jsp" ).forward( request, response );
                }
                break;
            default:
                homeEmployee( request, response );
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        String search = request.getParameter( "search" );
        String id = request.getParameter( "id" );
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                employeeService.deleteEmployee( Integer.parseInt( id ) );
                homeEmployee( request, response );
                break;
            case "update":
                request.setAttribute( "employee", employeeService.findEmployeeById( Integer.parseInt( id ) ) );
                request.getRequestDispatcher( "employee/update_employee.jsp" ).forward( request, response );
                break;
            case "search":
                request.setAttribute( "search", search );
                request.setAttribute( "listEmployee", employeeService.findEmployee( search ) );
                request.getRequestDispatcher( "employee/employee.jsp" ).forward( request, response );
                break;
            default:
                homeEmployee( request, response );
        }
    }

    private void homeEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute( "listEmployee", employeeService.showEmployee() );
        request.getRequestDispatcher( "employee/employee.jsp" ).forward( request, response );
    }


}
