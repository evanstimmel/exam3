
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a New Customer</title>
        <link rel="stylesheet" type="text/css" href="./css/stylesheet1.css" />
    </head>
    <body>
        
        
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
        
            <%@ include file="includes/menu.jsp" %>
            
            
             <div class="main">
        
        
        
        <h1>Add Customer</h1>
         
            <form name="addForm" action="addCustomer" method="get">

                <label>First Name:</label>
                <br>
                <input type="text" name="firstName" value="" />
                <br>
                <label>Last Name:</label>
                <br>
                <input type="text" name="lastName" value="" />
                <br>
                <label>Address1:</label>
                <br>
                <input type="text" name="addr1" value="" />
                <br>
                <label>Address2:</label>
                <br>
                <input type="text" name="addr2" value="" />
                <br>
                <label>City:</label>
                <br>
                <input type="text" name="city" value="" />
                <br>
                <label>State:</label>
                <br>
                <input type="text" name="state" value="" />
                <br>
                <label>Zip</label>
                <br>
                <input type="text" name="zip" value="" />
                <br>
                <label>Email Address:</label>
                <br>
                <input type="text" name="emailAddr" value="" />
                <br>
                <input type="submit" name="submit" value="Submit" />
                
            </form>
                 
         </div>
       
            <%@ include file="includes/footer.jsp" %>
        
        </div>
        
        
    </body>
</html>
