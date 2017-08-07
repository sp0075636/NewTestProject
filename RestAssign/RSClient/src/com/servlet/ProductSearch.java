package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;

/**
 * Servlet implementation class ProductSearch
 */
@WebServlet("/ProductSearch")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Inside Post");
		ArrayList <Product> prodList=new ArrayList <Product>();
		String pname=request.getParameter("pname");
		String url="http://localhost:8080/RestServer/rs/product/productlist";
        boolean invokeRS=false;
    	
	      if(pname!=null && !"".equals(pname))
		{
			url=url+"?pname="+pname;
			invokeRS=true;
		}
		
		
		if(invokeRS)
		{
		Client client = ClientBuilder.newClient();
	    String Message=client.
	    		target(url).request(MediaType.APPLICATION_JSON).get(String.class);
		
	    
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			prodList = mapper.readValue(Message, new TypeReference<ArrayList<Product>>(){});
			
			
			if(prodList.isEmpty())
			{
			    request.getSession().setAttribute("noRecords","true");
			}
			else
			{
				request.getSession().setAttribute("prodList",prodList);
				
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		   
		}
		 
		RequestDispatcher dispatcher= request.getRequestDispatcher("ProductSearch.jsp");
		dispatcher.forward(request, response);
		return;
	}

}