<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<edu.karima.model.Product> producten = (ArrayList<edu.karima.model.Product>)request.getAttribute("producten");%>

<table>
<tr>
	<td><b>Naam</b></td>
	<td><b>Producent</b></td>
	<td><b>Prijs</b></td>
</tr>
<%
	for(edu.karima.model.Product p: producten) {
		

		out.println("<tr><td>" + p.getNaam() + "</td>" + "<td>" + p.getProducent() + "</td>" + "<td>" + p.getPrijs() + "</td></tr>");
	}

%>

</table>
</body>
</html>