package br.senai.projeto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bloco")
@Getter
@Setter
@NoArgsConstructor
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloco")
    private Long idBloco;

    @Column(name = "cor_esquerda", nullable = false)
    private String corEsquerda;

    @Column(name = "cor_direita", nullable = false)
    private String corDireita;

    @Column(name = "cor_frontal", nullable = false)
    private String corFrontal;

    @Column(name = "forma_esq", nullable = false)
    private String formaEsq;

    @Column(name = "forma_dir", nullable = false)
    private String formaDir;

    @Column(name = "forma_front", nullable = false)
    private String formaFront;

    @ManyToOne
    @JoinColumn(name = "id_pedido_producao", nullable = false)
    private PedidoProducao pedidoProducao;
}