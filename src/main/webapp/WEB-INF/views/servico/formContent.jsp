<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${servico.id != null ? '/servicos/' + servico.id + '/atualizar' : '/servicos'}"
      method="post" enctype="multipart/form-data">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="${servico.nome}" required/></td>
        </tr>
        <tr>
            <td>Descrição:</td>
            <td><input type="text" name="descricao" value="${servico.descricao}" required/></td>
        </tr>
        <tr>
            <td>Preço:</td>
            <td><input type="number" step="0.01" name="preco" value="${servico.preco}" required/></td>
        </tr>
        <tr>
            <td>Imagem do Serviço:</td>
            <td>
                <input type="file" name="imagem" accept="image/*" />
                <c:if test="${not empty servico.imagem}">
                    <br><img src="${pageContext.request.contextPath}/uploads/${servico.imagem}" width="100" />
                </c:if>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">${servico.id != null ? 'Atualizar' : 'Salvar'}</button>
            </td>
        </tr>
    </table>
</form>
