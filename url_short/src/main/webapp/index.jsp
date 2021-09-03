
<%@page import="com.url_short.model.LinkBean"%>
<%@page import="com.url_short.persistence.LinkDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Url Shortener</title>
<style type="text/css">


	
	.main{
	 
	  margin-top: 100px;
	  margin-bottom: 100px;
	  margin-right: 150px;
	  margin-left: 80px;
	  background-color: ;
	}
	.main{
		width: 700px;
		margim: ;
	}
    #customers {
	  font-family: Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
    #customers th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}
	
	#customers tr:nth-child(even){background-color: #f2f2f2;}
	
	#customers tr:hover {background-color: #ddd;}
	
	#customers th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: #04AA6D;
	  color: white;
</style>
</head>
<body>
			
			<div class="main">
				<h1>URL SHORTNER - AVALIACAO LOGIQUE</h1>
				
					<form action="InserirUrlController" method="POST">
					 <input type="url" required="required"  name="url" placeholder="url">
					 <input type="submit" value="Create URL">
				</form>
				<table border="1" id="customers">
					<thead>
						<tr>
							<th>Id</th>
							<th>URL</th>
							<th>Code</th>
							<th>Custom</th>
						</tr>
					</thead>		
					<tbody>
					
					<%= request.getAttribute("msg") %>
					
						<%
						
							out.print(request.getParameter("msg")); 
							LinkDAO linkDAO = new LinkDAO();
							for(LinkBean link : linkDAO.findAll()){
								out.print("<tr>");
								out.print("<td>"+link.getId()+"</td>");
								out.print("<td>"+link.getUrl()+"</td>");
								out.print("<td>dominio/"+link.getCode()+"</td>");
								out.print("<td>dominio/"+link.getCustom()+"</td>");
								out.print("</tr>");
							}
						
						%>
					
					</tbody>
				</table>
			</div>
</body>
</html>