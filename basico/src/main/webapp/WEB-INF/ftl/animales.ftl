<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animales</title>
</head>
<body>
	<h1>Animales</h1>
	
	<ul>
		<#list animales as a>
			<li>${a.nombre} - ${a.tipo}</li>			
		</#list>
	</ul>
</body>
</html>