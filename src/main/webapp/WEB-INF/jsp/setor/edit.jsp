<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Setores</title>
</head>
<body>
	<h2>Cadastro de Setores</h2>
	<form action="/chamados/setor/save" method="post" > 
	<input type="hidden" name="setor.idSetor" value="${ setor.idSetor }" />
		Nome: <input type="text" name="setor.nmSetor" value="${ setor.nmSetor }" /> 
	<br> 
	<br>
	<button type="submit">Gravar</button>
	<button onclick="forms[0].action='/chamados/setor/delete'">Excluir</button>
	<button onclick="forms[0].action='/chamados/setor/list'">Voltar</button>
	</form>
</body>
</html>