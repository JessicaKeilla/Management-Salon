<!-- src/main/webapp/WEB-INF/views/auth/loginContent.jsp -->
<h2>Login</h2>
<form method="post" action="<c:url value='/login'/>">
    <label for="username">Usuário:</label><br/>
    <input type="text" id="username" name="username" required><br/><br/>

    <label for="password">Senha:</label><br/>
    <input type="password" id="password" name="password" required><br/><br/>

    <button type="submit">Entrar</button>
</form>

<c:if test="${not empty param.error}">
    <p style="color:red;">Usuário ou senha inválidos.</p>
</c:if>

<p>Não tem uma conta? <a href="<c:url value='/register'/>">Registre-se</a></p>
