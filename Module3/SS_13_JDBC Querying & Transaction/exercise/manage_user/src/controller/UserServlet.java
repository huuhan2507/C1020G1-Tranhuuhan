package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserServlet", urlPatterns = {"", "/userServlet"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                createUser(request,response );
                break;
            case "update":
               updateUser( request,response );
                break;
            default:
        }
        goHome( request,response );
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter( "actionUser" );
        String search = request.getParameter( "country" );
        if (actionUser == null) {
            actionUser = "";
        }
        if (search == null){
            search = "";
        }
        switch (actionUser) {
            case "update":
                request.setAttribute( "users", userService.selectUser( Integer.parseInt( request.getParameter( "id" ) ) ) );
                request.getRequestDispatcher( "update_user.jsp" ).forward( request, response );
                break;
            case "delete":
                userService.deleteUser( Integer.parseInt( request.getParameter( "id" ) ) );
                goHome( request, response );
                break;
            case "sort":
                request.setAttribute( "list_users", userService.sortNameUser() );
                request.getRequestDispatcher( "display_user.jsp" ).forward( request, response );
                break;
            case "search":
                request.setAttribute( "country",search );
                request.setAttribute( "list_users", userService.searhCountryUser( search ) );
                request.getRequestDispatcher( "display_user.jsp" ).forward( request, response );
                break;
            default:
                goHome( request, response );
        }



    }

    private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute( "list_users", userService.selectAllUser() );
        request.getRequestDispatcher( "display_user.jsp" ).forward( request, response );
    }
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter( "id" );
        String name = request.getParameter( "name" );
        String email = request.getParameter( "email" );
        String country = request.getParameter( "country" );
        User user = new User( Integer.parseInt( id ),name,email,country );
        userService.insertUse( user );
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter( "id" );
        String name = request.getParameter( "name" );
        String email = request.getParameter( "email" );
        String country = request.getParameter( "country" );
        User user1 = new User( Integer.parseInt( id ),name,email,country );
        userService.updateUser( user1 );
    }


}
