/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import entities.Product;
import dao.*;
import java.sql.*;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductAccess {
    @GET
    @Path("/productlist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("pname") String pname)throws Exception{
    ArrayList<Product> product = new ArrayList<Product>();
    DbConnection db = new DbConnection();
    Connection con = db.getConnection();
    String query=null;
    
      if(pname!=null && !"".equals(pname))
    {
       query="select * from product where pname like '%"+pname+"%'";	
    }
      else
    {
    	query="select * from product";
    }
    PreparedStatement pst = con.prepareStatement(query);
    ResultSet rs = pst.executeQuery();
    while(rs.next()){
    Product p = new Product();
    p.setId(rs.getString("id"));
    p.setPname(rs.getString("pname"));
    p.setPrice(rs.getInt("price"));
    p.setCreateDate(rs.getString("created_date"));
    product.add(p);
     
    }
     return Response.status(200).entity(product).build();
    }
 
}
