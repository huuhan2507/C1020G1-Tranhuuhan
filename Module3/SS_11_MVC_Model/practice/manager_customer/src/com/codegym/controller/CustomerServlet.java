package com.codegym.controller;

import com.codegym.bean.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = {"", "/customerServlet"})
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter( "id" ) ;
        String name = request.getParameter( "name" );
        String email = request.getParameter( "email" );
        String address = request.getParameter( "address" );
        Customer customer = new Customer( Integer.parseInt( id),name,email,address );
        customerService.save( customer );
        goHome( request,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "create":
                response.sendRedirect( "create_customer.jsp" );
                break;
            case "update":
                Integer id_update = Integer.parseInt( request.getParameter( "id" ) );
                request.setAttribute( "customerInfo",customerService.findById( id_update ) );
                request.getRequestDispatcher( "update_customer.jsp" ).forward( request,response );
                break;
            case "delete":
                Integer id_delete= Integer.parseInt( request.getParameter( "id" ) );
                customerService.delete( id_delete );
                goHome( request, response );
                break;
            default:
                goHome( request, response );
        }
    }

    private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerListFromServlet", customerService.findAll());
        request.getRequestDispatcher( "display_customer.jsp" ).forward( request,response );
    }
}
