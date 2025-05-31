<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <title><c:out value="${pageTitle != null ? pageTitle : 'Beauty Salon'}"/></title>
    <link rel="stylesheet" href="<c:url value='/src/main/webapp/css'/>" />
</head>
<body>
<header>
    <div class="container">
        <h1>Beauty Salon</h1>
        <nav>
            <ul>
                <li><a href="<c:url ><value>/clientes</value></c:url>">Clientes</a></li>
                <li><a href="<c:url ><value>/agendamentos</value></c:url>">Agendamentos</a></li>
                <li><a href="<c:url ><value>/servicos</value></c:url>">Serviços</a></li>
                <li><a href="<c:url value='/roles'/>">Roles</a></li>
                <li><a href="<c:url value='/usuarios'/>">Usuários</a></li>
            </ul>
        </nav>
    </div>
</header>

<main class="container">
    <jsp:include page="${contentPage}" />
</main>

<footer>
    <div class="container">
        <p>&copy; 2025 Beauty Salon - Todos os direitos reservados.</p>
    </div>
</footer>
</body>
</html>
