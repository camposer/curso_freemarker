<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
<link rel="stylesheet" href="/ejercicio1/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Productos</h1>
		<br>
		
		<#if errores??>
		<div class="alert alert-danger" role="alert">
			<#list errores as e>
				${e}<br>					
			</#list>
		</div>
		</#if>

		<form action="guardar" method="post" class="form-horizontal">
			<input type="hidden" name="productoId" value="${producto.id!}">

			<div class="form-group">
				<label for="nombre" class="col-sm-2 control-label">Nombre</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="nombre"
						placeholder="Nombre" value="${producto.nombre!""}">
				</div>
			</div>

			<div class="form-group">
				<label for="precio" class="col-sm-2 control-label">Precio</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" name="precio"
						placeholder="Precio" value="${producto.precio!0}">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<button type="submit" class="btn btn-default">Guardar</button>
				</div>
			</div>

		</form>

		<hr>

		<table id="tabla-productos" class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Mostrar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<#list productos as p>
				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.precio}</td>
					<td><a href="mostrar?id=${p.id}">mostrar</a></td>
					<td><a href="eliminar?id=${p.id}">eliminar</a></td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>
	
	<script src="/ejercicio1/js/jquery.js"></script>
	<script src="/ejercicio1/js/bootstrap.js"></script>
</body>
</html>