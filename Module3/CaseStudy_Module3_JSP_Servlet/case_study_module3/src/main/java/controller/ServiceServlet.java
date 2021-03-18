package controller;

import bean.services.RentType;
import bean.services.Service;
import bean.services.ServiceType;
import repository.ServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.ServiceService;
import service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet",urlPatterns = "/serviceServlet")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        if (action==null){
            action="";
        }
        if (action.equals( "close" )){
            homeService( request,response );
        }
        String roomType = null;
        String rentTypeName=null;
        int rentTypeCost = 0;
        String typeName=null;
        int id = Integer.parseInt(  request.getParameter( "id" ));
        String name = request.getParameter( "name" );
        int area = Integer.parseInt( request.getParameter( "area" ) );
        double cost = Double.parseDouble( request.getParameter( "cost" ) );
        int people = Integer.parseInt( request.getParameter( "people" ) );
        int rentType = Integer.parseInt( request.getParameter( "rentType" ) );
        int type = Integer.parseInt( request.getParameter( "type" ) );
        int room = Integer.parseInt( request.getParameter( "room" ) );
        String doc = request.getParameter( "doc" );
        double areaPool = Double.parseDouble( request.getParameter( "ap" ) );
        int floor = Integer.parseInt( request.getParameter( "floor" ) );
        switch (rentType){
            case 1:
                rentTypeName="Hour";
                rentTypeCost=300;
                break;
            case 2:
                rentTypeName="Day";
                rentTypeCost=1000;
                break;
            case 3:
                rentTypeName="Month";
                rentTypeCost=5000;
                break;
            case 4:
                rentTypeName="Year";
                rentTypeCost=5000;
                break;
            default:
        }
        switch (type){
            case 1:
                typeName = "Villa";
                break;
            case 2:
                typeName = "House";
                break;
            case 3:
                typeName = "Room";
                break;
            default:
        }
        switch (room){
            case 1:
                roomType = "Vip";
                break;
            case 2:
                roomType = "Business";
                break;
            case 3:
                roomType = "Normal";
                break;
            default:
        }
        Service service = new Service( id,name,area,cost,people,new RentType( rentType,rentTypeName,rentTypeCost )
                ,new ServiceType( type ,typeName ),roomType,doc,areaPool,floor );
        switch (action){
            case "create":
                serviceService.createService( service );
                homeService( request,response );
                break;
            case "update":
                serviceService.editService( service );
                homeService( request,response );
                break;
            default:
                homeService( request,response );
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" );
        String id = request.getParameter( "id" );
        String search = request.getParameter( "search" );
        if (action==null){
            action="";
        }
        switch (action){
            case "search":
                request.setAttribute( "search",search );
                request.setAttribute( "listService", serviceService.findServiceByName( search ) );
                request.getRequestDispatcher( "service/service.jsp" ).forward( request,response );
                break;
            case "update":
                request.setAttribute( "service", serviceService.findServiceById( Integer.parseInt( id ) ) );
                request.getRequestDispatcher( "service/update_service.jsp" ).forward( request,response );
                break;
            default:
                homeService( request,response );
        }
    }
    private void homeService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute( "listService", serviceService.showService() );
        request.getRequestDispatcher( "service/service.jsp" ).forward( request,response );
    }
}
