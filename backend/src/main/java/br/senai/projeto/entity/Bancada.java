package br.senai.projeto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bancada")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bancada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bancada")
    private int idBancada;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_conexao")
    private StatusConexaoBancada statusConexao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_uso")
    private StatusUsoBancada statusUso;

    @Column(name = "tempo_base_min")
    private int tempoBaseMin;

    @ManyToOne
    @JoinColumn(name = "id_unidade", nullable = false)
    private Unidade unidade;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}