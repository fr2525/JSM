<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de usuarios</title>

<link type="text/css" rel="stylesheet" href="/chamados/resources/displaytag/displaytag.css" media="screen" />
</head>
<body>
<button onclick="location.href='/chamados/setor/edit'">Novo usuario</button>
<br>

<div id="div_displaytagTable" style="width:50%"> 

	<display:table name="usuarios" requestURI="/chamados/usuario/list" sort="page" export="true" >
		<display:column property="idUsuario"  title="Cod" href="read" paramId="usuario.idUsuario" paramProperty="idUsuario" media="html" /> 
		<display:column property="nmUsuario" titleKey="nmUsuario" sortable="true" />
		<display:column property="dsEmail" titleKey="dsEmail" sortable="true" />
		<display:column property="nrTelefone" titleKey="nrTelefone" sortable="true" />
		<!-- <display:column property="stUsuario" titleKey="stUsuario" sortable="true" /> -->
	
	</display:table>
</div>

</body>
</html>