export interface UnidadeRequest {
  nome: string;
  cidade: string;
  endereco: string;
}

export interface UnidadeResponse {
  id: number;
  nome: string;
  cidade: string;
  endereco: string;
  status: 'ATIVA' | 'INATIVA';
}

const API_URL = 'http://localhost:8080/unidades';

async function tratarResposta<T>(resposta: Response): Promise<T> {
  if (!resposta.ok) {
    const mensagemErro = await resposta.text();
    throw new Error(`Erro HTTP ${resposta.status}: ${mensagemErro || resposta.statusText}`);
  }
  
  // Trata métodos como desativar() que retornam 'void' (200 OK sem corpo)
  const textoResposta = await resposta.text();
  return textoResposta ? JSON.parse(textoResposta) : ({} as T);
}

function validarDados(dados: UnidadeRequest): void {
  if (!dados.nome?.trim() || !dados.cidade?.trim() || !dados.endereco?.trim()) {
    throw new Error('Todos os campos (nome, cidade, endereço) devem ser preenchidos.');
  }
}

export const unidadeService = {
  // Corresponde ao @GetMapping listar()
  listar: async (): Promise<UnidadeResponse[]> => {
    const resposta = await fetch(API_URL);
    return tratarResposta<UnidadeResponse[]>(resposta);
  },

  // Corresponde ao @GetMapping("/{id}") buscarPorId()
  buscarPorId: async (id: number): Promise<UnidadeResponse> => {
    if (!id || id <= 0) throw new Error('ID inválido para busca.');
    const resposta = await fetch(`${API_URL}/${id}`);
    return tratarResposta<UnidadeResponse>(resposta);
  },

  // Corresponde ao @PostMapping cadastrar() com HTTP 201 CREATED
  cadastrar: async (dados: UnidadeRequest): Promise<UnidadeResponse> => {
    validarDados(dados);
    const resposta = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(dados),
    });
    return tratarResposta<UnidadeResponse>(resposta);
  },

  // Corresponde ao @PutMapping("/{id}") atualizar()
  atualizar: async (id: number, dados: UnidadeRequest): Promise<UnidadeResponse> => {
    if (!id || id <= 0) throw new Error('ID inválido para atualização.');
    validarDados(dados);
    const resposta = await fetch(`${API_URL}/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(dados),
    });
    return tratarResposta<UnidadeResponse>(resposta);
  },

  // Corresponde ao @PatchMapping("/{id}/desativar") desativar()
  desativar: async (id: number): Promise<void> => {
    if (!id || id <= 0) throw new Error('ID inválido para desativação.');
    const resposta = await fetch(`${API_URL}/${id}/desativar`, {
      method: 'PATCH',
    });
    await tratarResposta<void>(resposta);
  },
};