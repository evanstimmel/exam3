
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customers = (Customers) request.getAttribute("customers"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Update Customers</title>
    </head>
    <body>
        <h1>Update a Customer Record</h1>
        <form name="updateForm" action="updateCustomer" method="get">

            
                <label>CustomerID:</label>
                <br>
                <input type="text" name="id" value= "<%= customers.getCustomerID() %>" readonly/>
                <br>
                <label>FirstName:</label>
                <br>
                <input type="text" name="firstname" value="<%= customers.getFirstName() %>" />
                <br>
                <label>LastName:</label>
                <br>
                <input type="text" name="lastname" value="<%= customers.getLastName() %>" />
                <br>
                <label>Address1:</label>
                <br>
                <input type="text" name="addr1" value="" /><%= customers.getAddr1() %>
                <br>
                <label>Address2:</label>
                <br>
                <input type="text" name="addr2" value="<%= customers.getAddr2() %>" />
                <br>
                <label>City:</label>
                <br>
                <input type="text" name="city" value="<%= customers.getCity() %>" />
                <br>
                <label>State:</label>
                <br>
                <input type="text" name="state" value="<%= customers.getState() %>" />
                <br>
                <label>Zip</label>
                <br>
                <input type="text" name="zip" value="<%= customers.getZip() %>" />
                <br>
                <label>Email Address:</label>
                <br>
                <input type="text" name="emailaddr" value="<%= customers.getEmailAddr() %>" />
                <br><br>
                
                <input type="reset" name="reset" value="Clear" />
                <input type="submit" name="submit" value="Update"/>
                
                
            </form>
    </body>
</html>
