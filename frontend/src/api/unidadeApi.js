const BASE_URL = '/api/unidades';

/**
 * Função auxiliar para tratar a resposta e capturar erros HTTP
 */
async function handleResponse(response) {
  if (!response.ok) {
    const errorData = await response.json().catch(() => ({}));
    const errorMessage = errorData.message || `Erro na requisição (${response.status}): ${response.statusText}`;
    throw new Error(errorMessage);
  }

  // Trata respostas sem conteúdo (ex: HTTP 204)
  if (response.status === 204) {
    return null;
  }

  return response.json();
}

/**
 * Listar todas as unidades
 * GET /api/unidades
 */
export async function listarUnidades() {
  const response = await fetch(BASE_URL, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
    },
  });
  return handleResponse(response);
}

/**
 * Consultar unidade por ID
 * GET /api/unidades/{id}
 */
export async function buscarUnidadePorId(id) {
  const response = await fetch(`${BASE_URL}/${id}`, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
    },
  });
  return handleResponse(response);
}

/**
 * Cadastrar uma nova unidade
 * POST /api/unidades
 */
export async function cadastrarUnidade(unidade) {
  const response = await fetch(BASE_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
    },
    body: JSON.stringify(unidade),
  });
  return handleResponse(response);
}

/**
 * Atualizar os dados de uma unidade
 * PUT /api/unidades/{id}
 */
export async function atualizarUnidade(id, unidade) {
  const response = await fetch(`${BASE_URL}/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
    },
    body: JSON.stringify(unidade),
  });
  return handleResponse(response);
}

/**
 * Desativar uma unidade
 * PATCH /api/unidades/{id}/desativar
 */
export async function desativarUnidade(id) {
  const response = await fetch(`${BASE_URL}/${id}/desativar`, {
    method: 'PATCH',
    headers: {
      'Accept': 'application/json',
    },
  });
  return handleResponse(response);
}