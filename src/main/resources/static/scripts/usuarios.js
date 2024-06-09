import carregarCabecalho from "./cabecalho.js";
import getDados from "./getDados.js";


function buscarUsuariosTodos() {
    carregarUsuarios("/usuarios");
}

window.buscarUsuariosFiltrado = function() {
    const nome = document.getElementById('nome').value;
    const login = document.getElementById('login').value;
    const nivel = document.getElementById('nivel').value;
    const status = document.getElementById('status').value;

    let parametros = new URLSearchParams({
        nome: nome || '',
        login: login || '',
        nivel: nivel || '',
        status: status || ''
    }).toString();

    carregarUsuarios(`/usuarios/filtrar?${parametros}`);
}

function carregarUsuarios(endpoint){
    getDados(endpoint)
        .then(listaUsuarios => {
            const tabela = document.getElementById("tabela");
            const listaUsuariosHTML = listaUsuarios.map(usuario => `
            <tr onclick="location.href='./usuario.html?id=${usuario.id}'">
                <td class="px-2" scope="row">${usuario.nome}</td>
                <td class="px-2">${usuario.login}</td>
                <td class="px-2 d-none d-md-block">${usuario.nivel === 0 ? '0 - Super Usuário' : 
                                                     usuario.nivel === 1 ? '1 - Administrador' : 
                                                     usuario.nivel === 2 ? '2 - Operador' : 
                                                                           '3 - Apenas Consulta'}</td>
                <td class="px-2">
                    <input type="checkbox" class="form-check-input" readonly ${usuario.status === 'A' ? 'checked' : ''}>
                    Ativo
                </td>
            </tr>
            `).join('');

            tabela.innerHTML = listaUsuariosHTML;
        })
        .catch(error => console.error('Erro:', error));
}

window.limparFiltros = function() {
    document.getElementById('nome').value = '';
    document.getElementById('login').value = '';
    document.getElementById('nivel').value = '';
    document.getElementById('status').value = '';
}

carregarCabecalho();
buscarUsuariosTodos();