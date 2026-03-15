<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>

<style>

body{
font-family:Arial;
background:#f2f2f2;
}

.container{
width:400px;
margin:120px auto;
background:white;
padding:30px;
border-radius:10px;
box-shadow:0px 0px 10px gray;
text-align:center;
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
background:#28a745;
border:none;
color:white;
font-size:16px;
border-radius:5px;
}

button:hover{
background:#218838;
}

a{
display:block;
margin-top:10px;
}

</style>

</head>

<body>

<div class="container">

<h2>Add Product</h2>

<form action="add" method="post">

<input type="text" name="name" placeholder="Product Name" required>

<input type="number" name="price" placeholder="Price" min="1" step="0.01" required>

<input type="number" name="quantity" placeholder="Quantity" min="1" required>

<button type="submit">Add Product</button>

</form>

<a href="index.jsp">Back</a>

</div>

</body>
</html>