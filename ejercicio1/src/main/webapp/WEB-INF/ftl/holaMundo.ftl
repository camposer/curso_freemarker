<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola mundo</title>
</head>
<body>
<#assign mensaje = "Hola">
${mensaje} ${nombre}<br>
<#list animales as a>
	Nombre: ${a.nombre}, Tamaño: ${a.tipo}<br>
</#list>
<!-- Ejecutar http://localhost:8080/basico/hola-mundo -->
<#assign numeros = ["uno", "dos", "tres"]>
<#list numeros as n>
	<#if n == "uno">
		1
	<#elseif n == "dos">
		two	
	<#else>
		${n}
	</#if>
	<br>
</#list>
</body>
</html>