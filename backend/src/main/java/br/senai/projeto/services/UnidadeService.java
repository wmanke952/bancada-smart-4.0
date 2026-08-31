package br.senai.projeto.services;

import br.senai.projeto.dto.UnidadeRequest;
import br.senai.projeto.dto.UnidadeResponse;
import br.senai.projeto.entity.StatusUnidade;
import br.senai.projeto.entity.Unidade;
import br.senai.projeto.repository.UnidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public UnidadeResponse cadastrar(UnidadeRequest request) {
        Unidade unidade = new Unidade();

        unidade.setNome(request.getNome());
        unidade.setCidade(request.getCidade());
        unidade.setEndereco(request.getEndereco());

        // Toda unidade nova começa ativa
        unidade.setStatus(StatusUnidade.ATIVA);

        // O ID é gerado automaticamente ao salvar
        Unidade unidadeSalva = unidadeRepository.save(unidade);

        return converterParaResponse(unidadeSalva);
    }

    public List<UnidadeResponse> listar() {
        return unidadeRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public UnidadeResponse buscarPorId(Integer id) {
        Unidade unidade = buscarEntidadePorId(id);

        return converterParaResponse(unidade);
    }

    public UnidadeResponse atualizar(
            Integer id,
            UnidadeRequest request
    ) {
        Unidade unidade = buscarEntidadePorId(id);

        // Somente estes campos podem ser atualizados
        unidade.setNome(request.getNome());
        unidade.setCidade(request.getCidade());
        unidade.setEndereco(request.getEndereco());

        Unidade unidadeAtualizada = unidadeRepository.save(unidade);

        return converterParaResponse(unidadeAtualizada);
    }

    public void desativar(Integer id) {
        Unidade unidade = buscarEntidadePorId(id);

        // Não exclui o registro, apenas altera o status
        unidade.setStatus(StatusUnidade.INATIVA);
        unidadeRepository.save(unidade);
    }

    private Unidade buscarEntidadePorId(Integer id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Unidade não encontrada com o ID: " + id
                        )
                );
    }

    private UnidadeResponse converterParaResponse(Unidade unidade) {
        UnidadeResponse response = new UnidadeResponse();

        response.setId(unidade.getId());
        response.setNome(unidade.getNome());
        response.setCidade(unidade.getCidade());
        response.setEndereco(unidade.getEndereco());
        response.setStatus(unidade.getStatus());

        return response;
    }
}