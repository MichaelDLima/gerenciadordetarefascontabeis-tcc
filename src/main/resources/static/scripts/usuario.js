import carregarCabecalho from "./cabecalho.js";
import getDados from "./getDados.js";
import postDados from "./postDados.js";

const parametro = new URLSearchParams(window.location.search);
const usuarioId = parametro.get('id');

function carregarUsuario() {
    if (usuarioId) {
        getDados(`/usuarios/${usuarioId}`)
            .then(usuario => {
                document.getElementById('nome').value = usuario.nome;
                document.getElementById('login').value = usuario.login;
                document.getElementById('senha').value = usuario.senha;
                document.getElementById('nivel').value = usuario.nivel;
                document.getElementById('status').checked = usuario.status === 'A';
            });
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formulario');
    const alertaSuccesso = document.getElementById('alertaSuccesso');
    const alertaErro = document.getElementById('alertaErro');

    formulario.addEventListener('submit', function (event) {

        event.preventDefault();

        const nome = document.getElementById('nome').value;
        const login = document.getElementById('login').value;
        const senha = document.getElementById('senha').value;
        const nivel = document.getElementById('nivel').value;
        const status = document.getElementById('status').checked ? 'A' : 'I';

        const usuario = {
            id: usuarioId,
            nome: nome,
            login: login,
            senha: senha,
            nivel: nivel,
            status: status
        };

        postDados('/usuarios/gravar', usuario)
            .then(usuarioGravado => {
                alertaSuccesso.classList.remove('d-none');
                alertaErro.classList.add('d-none');

                setTimeout(() => {
                    alertaSuccesso.classList.add('d-none');
                    window.location.href = `./usuario.html?id=${usuarioGravado.id}`
                }, 1000);
            })
            .catch((error) => {
                alertaSuccesso.classList.add('d-none');
                alertaErro.classList.remove('d-none');
                alertaErro.innerText = ' ' + error.message;
                console.error('Erro:', error);

                setTimeout(() => {
                    alertaErro.classList.add('d-none');
                }, 1000);
            });
    });

});

carregarCabecalho();
carregarUsuario();
