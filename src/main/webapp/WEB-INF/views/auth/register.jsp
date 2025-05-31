<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("pageTitle", "Registro");
    request.setAttribute("contentPage", "/WEB-INF/views/auth/registerContent.jsp");
%>
<jsp:include page="/WEB-INF/views/template/layout.jsp" />
