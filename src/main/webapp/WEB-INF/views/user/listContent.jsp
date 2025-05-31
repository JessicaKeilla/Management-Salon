<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Usuários</h2>
<button onclick="window.location.href='/usuarios/novo'">Novo Usuário</button>
<br><br>

<table border="1" id="usuariosTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <!-- AJAX vai preencher aqui -->
    </tbody>
</table>

<script>
    $(document).ready(function () {
        $.getJSON("/api/usuarios", function (usuarios) {
            let linhas = "";
            usuarios.forEach(function (u) {
                linhas += `<tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td>${u.email}</td>
                    <td>
                        <a href="/usuarios/${u.id}">Editar</a>
                        <form action="/usuarios/${u.id}/deletar" method="post" style="display:inline;">
                            <button type="submit" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</button>
                        </form>
                    </td>
                </tr>`;
            });
            $("#usuariosTable tbody").html(linhas);
        });
    });
</script>