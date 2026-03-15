package com.shopping.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.shopping.dao.CartDAO;
import com.shopping.model.Product;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(request.getParameter("id"));

        Product p=CartDAO.getProductById(id);

        request.setAttribute("product",p);

        RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));

        CartDAO.updateProduct(id,name,price,quantity);

        response.sendRedirect("view");
    }
}