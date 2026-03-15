package com.shopping.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.shopping.dao.CartDAO;

@WebServlet("/view")
public class ViewServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        request.setAttribute("products",CartDAO.getAllProducts());
        request.setAttribute("total",CartDAO.getTotal());

        RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }
}