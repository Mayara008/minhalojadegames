package br.org.generation.minhalojadegames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*import org.generation.minha_loja_de_game.model.Usuario;*/

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioRepository, Long>{
	public Optional<UsuarioRepository> findByUsuario(String usuario);
}
