package com.shopping.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.shopping.dao.CartDAO;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	        throws ServletException,IOException{

	    String name = request.getParameter("name");
	    double price = Double.parseDouble(request.getParameter("price"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    // Validation
	    if(price <= 0 || quantity <= 0){

	        response.getWriter().println("<h3 style='color:red'>Price and Quantity must be greater than 0</h3>");
	        response.getWriter().println("<a href='add.jsp'>Go Back</a>");
	        return;
	    }

	    CartDAO.addProduct(name,price,quantity);

	    response.sendRedirect("view");
	}
}