package br.senai.projeto.controller;

import br.senai.projeto.dto.UnidadeRequest;
import br.senai.projeto.dto.UnidadeResponse;
import br.senai.projeto.services.UnidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    // GET /unidades
    @GetMapping
    public List<UnidadeResponse> listarUnidades() {
        return unidadeService.listar();
    }

    // GET /unidades/{id}
    @GetMapping("/{id}")
    public UnidadeResponse buscarUnidade(@PathVariable Integer id) {
        return unidadeService.buscarPorId(id);
    }

    // POST /unidades
    @PostMapping
    public UnidadeResponse criarUnidade(
            @RequestBody UnidadeRequest request) {

        return unidadeService.cadastrar(request);
    }

    // PUT /unidades/{id}
    @PutMapping("/{id}")
    public UnidadeResponse atualizarUnidade(
            @PathVariable Integer id,
            @RequestBody UnidadeRequest request) {

        return unidadeService.atualizar(id, request);
    }

    // DELETE /unidades/{id}
    @DeleteMapping("/{id}")
    public void excluirUnidade(@PathVariable Integer id) {
        unidadeService.desativar(id);
    }
}