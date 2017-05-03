
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customer = (Customers) request.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/stylesheet1.css" />
        <title>Update Customers</title>
    </head>
    <body>
        
        
        
        
        
        
        <h1>Update a Customer Record</h1>
        <form name="updateForm" action="updateCustomer" method="get">

            
                <label>Customer ID:</label>
                <br>
                <input type="text" name="id" value= "<%= customer.getCustID() %>" readonly/>
                <br>
                <label>First Name:</label>
                <br>
                <input type="text" name="firstname" value="<%= customer.getFirstName() %>" />
                <br>
                <label>Last Name:</label>
                <br>
                <input type="text" name="lastname" value="<%= customer.getLastName() %>" />
                <br>
                <label>Address1:</label>
                <br>
                <input type="text" name="addr1" value="" /><%= customer.getAddr1() %>
                <br>
                <label>Address2:</label>
                <br>
                <input type="text" name="addr2" value="<%= customer.getAddr2() %>" />
                <br>
                <label>City:</label>
                <br>
                <input type="text" name="city" value="<%= customer.getCity() %>" />
                <br>
                <label>State:</label>
                <br>
                <input type="text" name="state" value="<%= customer.getCustState() %>" />
                <br>
                <label>Zip</label>
                <br>
                <input type="text" name="zip" value="<%= customer.getZip() %>" />
                <br>
                <label>Email Address:</label>
                <br>
                <input type="text" name="emailaddr" value="<%= customer.getEmailAddr() %>" />
                <br><br>
                
                <input type="reset" name="reset" value="Clear" />
                <input type="submit" name="submit" value="Update"/>
                
                
          
       
                
                
                
    </body>
</html>
