<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Setores</title>
</head>
<body>
	<h2>Cadastro de Usuarios</h2>
	<form action="/chamados/usuario/save" method="post" > 
	
	<ul>
	<c:forEach items="${ errors }" var="error" >
		<li>
			<fmt:message key="${ error.category}" />
			- 
			${ error.message }
		</li>
	</c:forEach>

		
	</ul>
	
	<input type="hidden" name="usuario.idUsuario" value="${ usuario.idUsuario }" />
	<fmt:message key="nmUsuario" />:  <input type="text" name="usuario.nmUsuario" value="${ usuario.nmUsuario }" /> 
	<br> 
	<fmt:message key="dsEmail" />:  <input type="text" name="usuario.dsEmail" value="${ usuario.dsEmail }" /> 
	<br> 
	<fmt:message key="nrTelefone" />:  <input type="text" name="usuario.nrTelefone" value="${ usuario.nrTelefone }" /> 
	<br>
	<fmt:message key="idSetor" />: 
		<select name="idSetor" >
			<option>Setor x</option>
			<option>Setor y</option>
		</select>	 
	<br> 
	<fmt:message key="dsSenha" />:  <input type="password" name="usuario.dsSenha" value="${ usuario.dsSenha }" /> 
	<br> 
	<fmt:message key="dsSenhaConfirm" />:  <input type="password" name="usuario.dsSenhaConfirm"  /> 
	<br> 
	<fmt:message key="stUsuario" />: 
		<select name="stUsuario" >
			<option>Ativo</option>
			<option>Inativo</option>
		</select>	 
	<br> 

	<br>
	<button type="submit">Gravar</button>
	<button onclick="forms[0].action='/chamados/usuario/delete'">Excluir</button>
	<button onclick="forms[0].action='/chamados/usuario/list'">Voltar</button>
	</form>
</body>
</html>