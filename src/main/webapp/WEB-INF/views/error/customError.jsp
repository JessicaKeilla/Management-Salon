<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:directive.include file="/WEB-INF/views/template/layout.jsp" />

<jsp:output doctype-root-element="html" doctype-public="" doctype-system=""/>

<div style="text-align: center; margin-top: 100px;">
    <h1>Error ${errorCode}</h1>
    <p>${errorMessage}</p>
    <a href="<c:url value='/' />">Voltar para a página inicial</a>
</div>
