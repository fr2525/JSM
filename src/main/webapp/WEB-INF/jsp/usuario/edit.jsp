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
		<select name="usuario.setor.idSetor" >
		<option value="0">SELECIONE</option>
		<c:forEach items="${ setores }" var="setor">
			<option value="${ setor.idSetor }" <c:if test="${setor.idSetor == usuario.setor.idSetor }">SELECTED</c:if> >${ setor.nmSetor }</option>
		</c:forEach>
		</select>	 
	<br> 
	<fmt:message key="dsSenha" />:  <input type="password" name="usuario.dsSenha" value="${ usuario.dsSenha }" /> 
	<br> 
	<fmt:message key="dsSenhaConfirm" />:  <input type="password" name="usuario.dsSenhaConfirm"  /> 
	<br> 
	<fmt:message key="stUsuario" />: 
		<select name="usuario.stUsuario" >
			<c:forEach items="${ situacoes }" var="situacao">
			<option value="${ situacao }" <c:if test="${situacao.value == usuario.stUsuario.value }">SELECTED</c:if> > ${situacao } </option>
				
			</c:forEach>
		</select>
	 
	<br> 

	<br>
	<button type="submit">Gravar</button>
	<button onclick="forms[0].action='/chamados/usuario/delete'">Excluir</button>
	<button onclick="forms[0].action='/chamados/usuario/list'">Voltar</button>
	</form>
</body>
</html>