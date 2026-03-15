<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.shopping.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Product List</title>

<style>

body{
font-family: Arial;
background:#f2f2f2;
margin:0;
padding:0;
}

.container{
width:900px;
margin:60px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0px 0px 10px gray;
text-align:center;
}

h2{
margin-bottom:20px;
}

table{
width:100%;
border-collapse:collapse;
margin-top:20px;
}

th,td{
padding:12px;
border:1px solid #ddd;
}

th{
background:#007bff;
color:white;
}

tr:nth-child(even){
background:#f9f9f9;
}

.button{
padding:6px 12px;
color:white;
text-decoration:none;
border-radius:5px;
font-size:14px;
}

.update{
background:orange;
}

.delete{
background:red;
}

.back{
display:inline-block;
margin-top:20px;
padding:10px 20px;
background:#007bff;
color:white;
text-decoration:none;
border-radius:6px;
}

</style>

</head>

<body>

<div class="container">

<h2>Product List</h2>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Action</th>
</tr>

<%

List<Product> list = (List<Product>)request.getAttribute("products");

if(list!=null && list.size()>0){

for(Product p : list){

%>

<tr>

<td><%=p.getId()%></td>
<td><%=p.getName()%></td>
<td><%=p.getPrice()%></td>
<td><%=p.getQuantity()%></td>

<td>

<a class="button update" href="update?id=<%=p.getId()%>">Update</a>

<a class="button delete" href="delete?id=<%=p.getId()%>">Delete</a>

</td>

</tr>

<%
}
}
else{
%>

<tr>
<td colspan="5">No Products Found</td>
</tr>
<%
}
%>

</table>

<br>

<h3>Total Price : Rs <%=request.getAttribute("total")%></h3>

<a class="back" href="index.jsp">Back</a>

</div>

</body>
</html>