<%@ page import java.util.List %>
<%@ page com.model.Product %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search</title>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript">$(document).ready(function(){
    $('#table_id').DataTable();
});
</script>
</head>
<body>
 <form action="ProductSearch"  method="post">
 <br>Product Name  <input type="text" id ="pname" name="pname" size="25" class="input" maxlength="45">
 <input type="submit" value="Get Details" class="button"></form>
 
<br>
<br>
<%  List  prodList= null;
 //(String)session.getAttribute("prodList");  %>
<% boolean flag=(boolean) session.getAttribute("noRecords"); 

if(flag)
{
%>
<b>No Records to display.</b>
<%} %>
<br>
<table id="table_id" class="display" border="1" cellpadding="1" cellspacing="1" width="100%" align="center" >
    <thead>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Create date</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>kiran</td>
            <td>Siva</td>
            <td>kiran</td>
            <td>Siva</td>
        </tr>
     
    </tbody>

</table>
</body>
</html>