<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Formulário de Cliente</h2>

<form:form method="post" action="${cliente.id==null ? '/clientes' : '/clientes/' + cliente.id + '/atualizar'}">
    <modelAttribute>cliente</modelAttribute>
    <form:hidden path="id"/>

    <div>
        <label>Nome:</label>
        <form:input path="nome"/>
        <form:errors path="nome" cssClass="error"/>
    </div>

    <div>
        <label>Email:</label>
        <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>

    <button type="submit">Salvar</button>
</form:form>

<%--<form method="post" action="/clientes">--%>
<%--    <input type="hidden" name="id" value="${cliente.id}"/>--%>

<%--    <label>Nome:</label><br>--%>
<%--    <input type="text" name="nome" value="${cliente.nome}" required/><br><br>--%>

<%--    <label>Email:</label><br>--%>
<%--    <input type="email" name="email" value="${cliente.email}" required/><br><br>--%>

<%--    <button type="submit">Salvar</button>--%>
<%--    <a href="/cliente">Cancelar</a>--%>
<%--</form>--%>