<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/stylesheet1.css" />
        <title>Customers</title>
    </head>
    <body>
        
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
        
            <%@ include file="includes/menu.jsp" %>
             
              
        
        
            <div class="main">
            
        <h1>Customers</h1>
        
        <a href="read">View All Customers</a>
        <br> <br>
        <a href="search.jsp">Search Customers</a>
        
            </div>
       
            <%@ include file="includes/footer.jsp" %>
        
        </div>
    </body>
</html>