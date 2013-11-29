package com.laptop.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.laptop.cart.LineItems;
import com.laptop.cart.ShoppingCart;
import com.laptop.dao.ProductDAO;
import com.laptop.dao.ProductDAOImpl;
import com.laptop.exception.LCAppException;
import com.laptop.pojo.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside doGet() of CartController");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("cart")!=null)
		{
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		List<LineItems> lineItemList = cart.getLineItemList();
		if(lineItemList!=null)
		{
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(lineItemList, new TypeToken<List<LineItems>>() {}.getType());
			 
		    JsonArray jsonArray = element.getAsJsonArray();
		    response.setContentType("application/json");
		    System.out.println(jsonArray);
		    out.print(jsonArray);
			
		}
		
		}
		
		System.out.println("Exiting doGet() of CartController");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside doPost() of CartController");
		int productId = Integer.parseInt(request.getParameter("productId"));
		String action = request.getParameter("action");
		if(productId!=0){
			ProductDAO productDAOImpl = new ProductDAOImpl();
			Product product;
			PrintWriter out = response.getWriter();
			try {
				product = productDAOImpl.getProduct(productId);
				if(product!=null)
				{
					int maxQuantity = product.getQty();
					HttpSession session = request.getSession();
					ShoppingCart cart = null;
					int quantity = 1;
					synchronized (session) {
						
						if(session.getAttribute("cart")!=null)
						{
						cart = (ShoppingCart)session.getAttribute("cart");
						}else {
							cart = new ShoppingCart();
							
						}
						
						LineItems lineItem = new LineItems();
						lineItem.setItem(product);
						lineItem.setQuantity(quantity);
						if(action.equalsIgnoreCase("add"))
						{
							cart.addItem(lineItem, maxQuantity);
						}else
						{
							cart.removeItem(lineItem);
						}
						session.setAttribute("cart", cart);
						out.print("success:");
					
				}
			 }else{
				 out.print("failed:Product Sold out");
			 }	
				
			}catch (LCAppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  }
		System.out.println("Exiting doPost() of CartController");
		
	}

}
