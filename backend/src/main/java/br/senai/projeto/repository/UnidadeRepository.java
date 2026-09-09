package br.senai.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.projeto.entity.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

}