package com.shopping.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.shopping.dao.CartDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(request.getParameter("id"));

        CartDAO.deleteProduct(id);

        response.sendRedirect("view");
    }
}