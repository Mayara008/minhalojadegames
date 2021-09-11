package br.org.generation.minhalojadegames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*import org.generation.minhalojadegames.repository;*/

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaRepository, Long > {
		public List <CategoriaRepository> findAllByGeneroContainingIgnoreCase(String genero);

}