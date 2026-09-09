package br.senai.projeto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

/**
 * Representa um usuario cadastrado na tabela {@code public.usuario}.
 *
 * <p>O identificador e fornecido pelo Supabase Auth. A senha nao pertence a
 * esta entidade, pois a autenticacao e administrada pelo Supabase Auth.</p>
 *
 * @since 2026-09-09
 * @author Iuri Farias
 * @version 1.0
 *
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private UUID idUsuario;

    /** Nome completo do usuario. */
    private String nome;

    /** Endereco de e-mail unico do usuario. */
    private String email;

    /** Perfil definido pelo tipo enum {@code public.perfil_usuario}. */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "perfil_usuario")
    private PerfilUsuario perfil;

    /** Indica se o usuario esta ativo no sistema. */
    @Column(nullable = false)
    private boolean ativo = true;

    /** Data e hora de criacao do registro. */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    /** Data e hora da ultima atualizacao do registro. */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    /** Unidade principal associada ao usuario, quando aplicavel. */
    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Retorna o instante em que o usuario foi criado.
     *
     * @return data e hora de criacao do registro
     */
    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * Retorna o instante da ultima atualizacao do usuario.
     *
     * @return data e hora da ultima alteracao do registro
     */
    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
