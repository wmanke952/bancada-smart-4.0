package br.senai.projeto.exception;

/**
 * Exceção lançada quando um recurso solicitado (ex.: Unidade) não é
 * encontrado na base de dados.
 *
 * É tratada globalmente pelo {@link GlobalExceptionHandler}, que converte
 * essa exceção em uma resposta HTTP 404 (Not Found) padronizada.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Object id) {
        super(String.format("%s não encontrada com o id: %s", resourceName, id));
    }
}