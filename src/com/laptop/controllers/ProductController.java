package com.laptop.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.laptop.dao.ProductDAO;
import com.laptop.dao.ProductDAOImpl;
import com.laptop.exception.LCAppException;
import com.laptop.pojo.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tenantId = Integer.parseInt(request.getParameter("tenantId"));
		System.out.println("Inside do get with Tenant ID"+tenantId);
		PrintWriter out = response.getWriter();
		ProductDAO productDAOImpl = new ProductDAOImpl();
		try {
			List<Product> productList = productDAOImpl.getAllProducts(tenantId);
			if(productList!=null){
				Gson gson = new Gson();
				//=============================================
				
				JsonElement element = gson.toJsonTree(productList, new TypeToken<List<Product>>() {}.getType());
		 
			    JsonArray jsonArray = element.getAsJsonArray();
			    response.setContentType("application/json");
				
				//=============================================
				
				
				//String products = gson.toJson(productList);
				//System.out.println("{\"Products\":"+products+"}");
				//out.print("{\"Products\":"+products+"}");
			    
			    System.out.println(jsonArray);
			    out.print(jsonArray);
				
				
			}else
			{
				out.print("Products:No Result Found");
			}
			
		} catch (LCAppException e) {
			e.printStackTrace();
			out.print("Products:No Result Found");
		}finally {
			
			out.close();
		}
		
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
