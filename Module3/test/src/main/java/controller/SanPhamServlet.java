package controller;

import bean.SanPham;
import repository.SanPhamRepository;
import repository.impl.SanPhamRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SanPhamServlet",urlPatterns = {"","/sanPhamServlet"})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String luaChon=request.getParameter( "luaChon" );
        String id = request.getParameter( "id" );
        String ten = request.getParameter( "name" );
        String gia = request.getParameter( "pice" );
        String mucGiamGia = request.getParameter( "discount" );
        String soluong = request.getParameter( "stock" );
        SanPham sanPham = new SanPham( Integer.parseInt( id ),ten,Double.parseDouble( gia ),Integer.parseInt( mucGiamGia ),Integer.parseInt( soluong ) );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String luaChon = request.getParameter( "luaChon" );
        if (luaChon==null){
            luaChon="";
        }
        switch (luaChon){
            case "xemNgay":
                break;
            case "xemTop":
                break;
            default:
                request.setAttribute( "danhSachSanPham",sanPhamRepository.hienThiSanPham() );
                request.getRequestDispatcher( "hienthisanpham.jsp" ).forward( request,response );
        }
    }
}
