package br.senai.projeto.dto;

import lombok.Data;

/**
 * DTO responsável por retornar os dados de uma unidade cadastrada.
 * Processo: consulta, exibição e resposta da unidade ao cliente.
 *
 * @author Iuri Vieira
 * @since 31/08/2026
 * @version 1.0
 */
@Data
public class UnidadeResponse {

    private Long id;
    private String nome;
    private String cidade;
    private String endereco;
    private StatusUnidade status;
}