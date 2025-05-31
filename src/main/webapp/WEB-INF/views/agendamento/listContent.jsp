<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Agendamentos</h1>
<a href="/agendamentos/novo">Novo Agendamento</a>
<table border="1">
    <thead>
    <tr>
        <th>Cliente</th>
        <th>Serviço</th>
        <th>Data</th>
        <th>Hora</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ag" items="${agendamentos}">
        <tr>
            <td>${ag.cliente.nome}</td>
            <td>${ag.servico.nome}</td>
            <td>${ag.data}</td>
            <td>${ag.hora}</td>
            <td>
                <a href="/agendamentos/delete/${ag.id}" onclick="return confirm('Confirmar exclusão?')">Excluir</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>