package br.senai.projeto.controller;

import br.senai.projeto.dto.UnidadeRequest;
import br.senai.projeto.dto.UnidadeResponse;
import br.senai.projeto.services.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
@CrossOrigin
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping
    public List<UnidadeResponse> listar() {
        return unidadeService.listar();
    }

    @GetMapping("/{id}")
    public UnidadeResponse buscarPorId(@PathVariable Integer id) {
        return unidadeService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnidadeResponse cadastrar(
            @Valid @RequestBody UnidadeRequest request
    ) {
        return unidadeService.cadastrar(request);
    }

    @PutMapping("/{id}")
    public UnidadeResponse atualizar(
            @PathVariable Integer id,
            @Valid @RequestBody UnidadeRequest request
    ) {
        return unidadeService.atualizar(id, request);
    }

    @PatchMapping("/{id}/desativar")
    public void desativar(@PathVariable Integer id) {
        unidadeService.desativar(id);
    }
}