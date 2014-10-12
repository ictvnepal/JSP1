<%-- 
    Document   : first
    Created on : Oct 12, 2014, 6:50:54 PM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bo.Blog,com.handlers.BlogHandler" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% //for(int i=1;i<=10;i++){%>
        <h1><i>Hello World! <% //out.println(i);%></i></h1>
        <%//}%>
        
        <a href="AddBlog.jsp">Add Blog</a>
        <table border="1">
            <tr>
                <th><input type="checkbox"/></th>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            
        <%
            /*Category c=new Category();
            c.setId(1);
            c.setName("test");
            
            out.println(c.toString());*/
            
           for(Blog b: BlogHandler.getAll()){
               out.println("<tr>");
               out.println("<td><input type=\"checkbox\"/>");
               out.println("<td>"+ b.getBlogId() + "</td>");
               out.println("<td>"+ b.getBlogTitle()+ "</td>");
               out.println("<td>"+ b.getBlogDescription() + "</td>");
               out.println("<td>"+ b.getStatus() + "</td>");
               out.println("<td>Edit <a href=\"javascript:void(0)\" onclick=\"return confirm('Are you sure to delete?')\" >Delete</a></td>");
               out.println("</tr>");
           }
            
            
        %>
        </table>
        
    </body>
</html>
