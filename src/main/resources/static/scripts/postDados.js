// URL base da API
const baseURL = 'http://localhost:8080';

export default function postDados(endpoint, dados) {
    return fetch(`${baseURL}${endpoint}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(err => { throw new Error(err); });
            }
            return response.json();
        });
}
