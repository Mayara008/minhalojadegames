package br.org.generation.minhalojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*import br.org.generation.minhalojadegames.Produto;*/

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoRepository, Long>{
		
public List <ProdutoRepository> findAllByNomeContainingIgnoreCase (String nome);
	
}