<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("pageTitle", "Login");
    request.setAttribute("contentPage", "/WEB-INF/views/auth/loginContent.jsp");
%>
<jsp:include page="/WEB-INF/views/template/layout.jsp" />
