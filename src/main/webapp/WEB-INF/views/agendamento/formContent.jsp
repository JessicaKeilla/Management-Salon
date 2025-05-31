<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Formulário de Agendamento</h2>

<form:form method="post"
           action="${agendamento.id == null ? '/agendamentos' : '/agendamentos/' + agendamento.id + '/atualizar'}">

    <modelAttribute>agendamento</modelAttribute>
    <form:hidden path="id"/>

    <div>
        <label>Cliente:</label>
        <form:select path="clienteId">
            <form:option value="" label="-- Selecione --"/>
            <c:forEach var="c" items="${clientes}">
                <form:option value="${c.id}" label="${c.nome}"/>
            </c:forEach>
        </form:select>
        <form:errors path="clienteId" cssClass="error"/>
    </div>

    <div>
        <label>Serviço:</label>
        <form:select path="servicoId">
            <form:option value="" label="-- Selecione --"/>
            <c:forEach var="s" items="${servicos}">
                <form:option value="${s.id}" label="${s.nome}"/>
            </c:forEach>
        </form:select>
        <form:errors path="servicoId" cssClass="error"/>
    </div>

    <div>
        <label>Data e Hora:</label>
        <form:input type="datetime-local" path="dataHora"/>
        <form:errors path="dataHora" cssClass="error"/>
    </div>

    <button type="submit">Salvar</button>
</form:form>
