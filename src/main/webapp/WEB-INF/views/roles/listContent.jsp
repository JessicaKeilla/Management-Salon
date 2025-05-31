<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Roles</h2>
<button onclick="window.location.href='/roles/novo'">Nova Role</button>
<br><br>

<table border="1" id="rolesTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <!-- Preenchido por AJAX -->
    </tbody>
</table>

<script>
    $(document).ready(function () {
        $.getJSON("/roles/api", function (roles) {
            let linhas = "";
            roles.forEach(function (r) {
                linhas += `<tr>
                    <td>${r.id}</td>
                    <td>${r.nome}</td>
                    <td>
                        <a href="/roles/editar/${r.id}">Editar</a>
                        <a href="/roles/delete/${r.id}">Excluir</a>
                    </td>
                </tr>`;
            });
            $("#rolesTable tbody").html(linhas);
        });
    });
</script>