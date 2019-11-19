package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	// Curso é a antidade e concatena com Nome que é atributo de Curso
	List<Topico> findByCurso_Nome(String nomeCurso);
	
	// Uma variação do filtro de pesquisa
	
	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	Page<Topico> carregaPorNomeDoCurso(@Param("nomeCurso") String nomeCurso, Pageable paginacao);
}
