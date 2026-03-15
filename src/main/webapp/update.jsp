<%@ page import="com.shopping.model.Product"%>

<%

Product p=(Product)request.getAttribute("product");

%>

<!DOCTYPE html>
<html>
<head>
<title>Update Product</title>

<style>

body{
font-family:Arial;
background:#f2f2f2;
}

.container{
width:400px;
margin:100px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0px 0px 10px gray;
}

input{
width:100%;
padding:10px;
margin:10px 0;
border-radius:5px;
border:1px solid #ccc;
}

button{
width:100%;
padding:10px;
background:#ffc107;
border:none;
font-size:16px;
border-radius:5px;
}

</style>
</head>

<body>

<div class="container">

<h2>Update Product</h2>

<form action="update" method="post">

<input type="hidden" name="id" value="<%=p.getId()%>">

<input type="text" name="name" value="<%=p.getName()%>">
3
<input type="number" name="price" min="1" step="0.01" required>

<input type="number" name="quantity" min="1" required>

<button type="submit">Update Product</button>

</form>

</div>

</body>
</html>