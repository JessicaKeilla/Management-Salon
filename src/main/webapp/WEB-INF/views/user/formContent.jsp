<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Formulário de Usuário</h2>

<%--@elvariable id="usuario" type="jakarta"--%>
<form:form method="post" modelAttribute="usuario"
           action="${usuario.id == null ? '/usuarios' : '/usuarios/' + usuario.id + '/atualizar'}">

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

    <div>
        <label>Senha:</label>
        <form:password path="senha"/>
        <form:errors path="senha" cssClass="error"/>
    </div>

    <div>
        <label>Roles:</label>
        <form:select path="roleIds" multiple="true">
            <c:forEach var="r" items="${roles}">
                <form:option value="${r.id}" label="${r.nome}"/>
            </c:forEach>
        </form:select>
        <form:errors path="roleIds" cssClass="error"/>
    </div>

    <form action="${formAction}" method="post" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label>Imagem de perfil:</label>
    <input type="file" name="imagem" accept="image/*"/><br>

    <c:if test="${usuario.imagemUrl != null}">
        <img src="<c:url value='/uploads/usuarios/${usuario.imagemUrl}'/>" width="100"/>
    </c:if>

    <button type="submit">Salvar</button>
</form:form>
