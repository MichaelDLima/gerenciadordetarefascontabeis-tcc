import carregarCabecalho from "./cabecalho.js";
import getDados from "./getDados.js";

function carregarSumario() {
    getDados(`/home/sumario`)
        .then(sumario => {
            document.getElementById('pendentes').textContent = `${sumario.pendentes}`;
            document.getElementById('em-andamento').textContent = `${sumario.emAndamento}`;
            document.getElementById('vencem-hoje').textContent = `${sumario.vencemHoje}`;
            document.getElementById('vencidas').textContent = `${sumario.vencidas}`;
        })
        .catch(error => {
            console.error('Erro ao obter sumario das tarefas:', error);
        });
}

// Carrega o cabeçalho da pagina
carregarCabecalho();
// Carrega o sumário quando a página carrega
carregarSumario();
