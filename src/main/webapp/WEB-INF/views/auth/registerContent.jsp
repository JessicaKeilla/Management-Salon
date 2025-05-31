<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<!-- src/main/webapp/WEB-INF/views/auth/registerContent.jsp -->
<h2>Registro de Novo Usuário</h2>
<form method="post" action="<c:url value='/register'/>">
    <label for="username">Usuário:</label><br/>
    <input type="text" id="username" name="username" required><br/><br/>

    <label for="email">Email:</label><br/>
    <input type="email" id="email" name="email" required><br/><br/>

    <label for="password">Senha:</label><br/>
    <input type="password" id="password" name="password" required><br/><br/>

    <button type="submit">Registrar</button>
</form>

<c:if test="${not empty param.success}">
    <p style="color:green;">Usuário registrado com sucesso! Faça login.</p>
</c:if>

<p>Já tem uma conta? <a href="<c:url value='/login'/>">Entrar</a></p>
