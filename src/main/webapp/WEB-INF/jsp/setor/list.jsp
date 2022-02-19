<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de setores</title>

<link type="text/css" rel="stylesheet" href="/chamados/resources/displaytag/displaytag.css" media="screen" />
</head>
<body>
<button onclick="location.href='/chamados/setor/edit'">Novo setor</button>
<br>

<div id="div_displaytagTable" style="width:50%"> 

	<display:table name="setores" requestURI="/chamados/setor/list" sort="page" export="true" >
		<display:column property="idSetor"  title="Cod" href="read" paramId="setor.idSetor" paramProperty="idSetor" media="html" /> 
		<display:column property="nmSetor" titleKey="nmSetor" sortable="true" />
	
	</display:table>
</div>

</body>
</html>