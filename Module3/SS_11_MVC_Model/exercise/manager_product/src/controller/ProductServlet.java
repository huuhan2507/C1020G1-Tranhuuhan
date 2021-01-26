package controller;

import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter( "actionUser" );
        if (actionUser == null){
            actionUser="";
        }
        switch (actionUser){
            case "add":
                response.sendRedirect( "add_product.jsp" );
                break;
            case "update":
                Integer updateId= Integer.parseInt( request.getParameter( "" ) );
                request.setAttribute( "customerInfo",productService.showInfoProduct( updateId ) );
                request.getRequestDispatcher( "update_product.jsp" ).forward( request,response );
                break;


        }
    }
}
