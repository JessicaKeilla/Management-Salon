<%
    request.setAttribute("pageTitle", "Lista de Serviços");
    request.setAttribute("contentPage", "/WEB-INF/views/servicos/listContent.jsp");
%>
<jsp:include page="/WEB-INF/views/template/layout.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Lista de Serviços</h2>

<a href="${pageContext.request.contextPath}/servicos/novo">Novo Serviço</a>
<br><br>

<table border="1" cellpadding="8">
    <thead>
    <tr>
        <th>Imagem</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço (R$)</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="servico" items="${servicos}">
        <tr>
            <td>
                <c:if test="${not empty servico.imagem}">
                    <img src="${pageContext.request.contextPath}/uploads/${servico.imagem}" width="80" height="60" />
                </c:if>
            </td>
            <td>${servico.nome}</td>
            <td>${servico.descricao}</td>
            <td>${servico.preco}</td>
            <td>
                <a href="${pageContext.request.contextPath}/servicos/edit/${servico.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/servicos/delete/${servico.id}"
                   onclick="return confirm('Tem certeza que deseja excluir este serviço?');">Excluir</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
