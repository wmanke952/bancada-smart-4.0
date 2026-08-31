package br.senai.projeto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO responsável por receber os dados de cadastro de uma unidade.
 * Processo: criação e validação da unidade no sistema.
 *
 * @author Iuri Farias 
 * @since 31/08/2026
 * @version 1.0
 */
@Data
public class UnidadeRequest {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;
}