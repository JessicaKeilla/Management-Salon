<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Clientes</h2>

<button onclick="window.location.href='/clientes/novo'">Novo Cliente</button>
<br><br>

<table border="1" id="clientesTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${clientes}">
        <tr>
            <td>${c.id}</td>
            <td>${c.nome}</td>
            <td>${c.email}</td>
            <td>
                <a href="/clientes/edit/${c.id}">Editar</a>
                <a href="/clientes/delete/${c.id}" onclick="return confirm('Deseja realmente excluir este cliente?');">Excluir</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
