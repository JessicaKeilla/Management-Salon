<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Serviços</h2>

<button onclick="window.location.href='/servicos/Novo'">Novo Serviço</button>
<br><br>

<table border="1" id="servicosTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço</th>
        <th>Ações</th>
    </tr>
    </thead>
    <tbody>
    <!-- AJAX preencherá aqui -->
    </tbody>
</table>

<script>
    $(document).ready(function () {
        $.getJSON("/api/servicos", function (servicos) {
            let linhas = "";
            servicos.forEach(function (s) {
                linhas += `
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.nome}</td>
                        <td>${s.descricao}</td>
                        <td>R$ ${s.preco.toFixed(2)}</td>
                        <td>
                            <a href="/servicos/editar/${s.id}">Editar</a> |
                            <a href="/servicos/excluir/${s.id}">Excluir</a>
                        </td>
                    </tr>`;
            });
            $("#servicosTable tbody").html(linhas);
        });
    });
</script>