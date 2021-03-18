package controller;

import bean.customer.Customer;
import bean.customer.CustomerType;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        if (action.equals( "close" )) {
            homeCustomer( request, response );
        }
        int id = Integer.parseInt( request.getParameter( "id" ) );
        int type = Integer.parseInt( request.getParameter( "type" ) );
        String typeName = null;
        switch (type) {
            case 1:
                typeName = "Diamond";
                break;
            case 2:
                typeName = "Platinum";
                break;
            case 3:
                typeName = "Gold";
                break;
            case 4:
                typeName = "Silver";
                break;
            case 5:
                typeName = "Member";
                break;
            default:
        }
        CustomerType customerType = new CustomerType( type, typeName );
        String name = request.getParameter( "name" );
        String birthday = request.getParameter( "birthday" );
        String gender = request.getParameter( "gender" );
        String cardId = request.getParameter( "cardId" );
        String phone = request.getParameter( "phone" );
        String email = request.getParameter( "email" );
        String address = request.getParameter( "address" );
        Customer customer = new Customer( id, customerType, name, birthday, gender, cardId, phone, email, address );
        List<String> errCustomer = customerService.validateCustomer( cardId, phone, email );
        switch (action) {
            case "create":
                if (customerService.validateCustomerInService(  cardId, phone, email )) {
                    customerService.createCustomer( customer );
                    homeCustomer( request, response );
                } else {
                    request.setAttribute( "errCustomer", errCustomer );
                    request.setAttribute( "customer", customer );
                    request.getRequestDispatcher( "customer/create_customer.jsp" ).forward( request, response );
                }
                break;
            case "update":
                if (customerService.validateCustomerInService( cardId, phone, email )) {
                    customerService.updateCustomer( customer );
                    homeCustomer( request, response );
                } else {
                    request.setAttribute( "errCustomer", errCustomer );
                    request.setAttribute( "customer", customer );
                    request.getRequestDispatcher( "customer/update_customer.jsp" ).forward( request, response );
                }
                break;
            default:
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
                customerService.deleteCustomer( Integer.parseInt( id ) );
                homeCustomer( request, response );
                break;
            case "update":
                request.setAttribute( "customer", customerService.searchCustomerById( Integer.parseInt( id ) ) );
                request.getRequestDispatcher( "customer/update_customer.jsp" ).forward( request, response );
                break;
            case "search":
                request.setAttribute( "search", search );
                request.setAttribute( "listCustomer", customerService.searchCustomer( search ) );
                request.getRequestDispatcher( "customer/customer.jsp" ).forward( request, response );
                break;
            default:
                homeCustomer( request, response );
        }
    }

    private void homeCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute( "listCustomer", customerService.showCustomer() );
        request.getRequestDispatcher( "customer/customer.jsp" ).forward( request, response );
    }
}
