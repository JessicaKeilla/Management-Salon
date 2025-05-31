<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Formulário de Role</h2>

<%--<form method="post" action="/roles">--%>
<%--    <input type="hidden" name="id" value="${role.id}" />--%>

<%--    <label>Nome da Role:</label><br>--%>
<%--    <input type="text" name="nome" value="${role.nome}" required/><br><br>--%>

<%--    <button type="submit">Salvar</button>--%>
<%--    <a href="/roles">Cancelar</a>--%>
<%--</form>--%>


<form:form method="post"
           action="${role.id == null ? '/roles' : '/roles/' + role.id + '/atualizar'}">

    <modelAttribute>role</modelAttribute>
    <form:hidden path="id"/>

    <div>
        <label>Nome da Role:</label>
        <form:input path="nome"/>
        <form:errors path="nome" cssClass="error"/>
    </div>

    <button type="submit">Salvar</button>
</form:form>
