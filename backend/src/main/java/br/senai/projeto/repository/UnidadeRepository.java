package br.senai.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.projeto.entity.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

}