package br.org.generation.minhalojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import org.generation.minhalojadegames.model.Categoria;
import org.generation.minhalojadegames.repository.CategoriaRepository; */


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaController categoriaRepository;
	
	@GetMapping
	private ResponseEntity<List<CategoriaController>> getAll(){
		
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping("/{id}")
	private ResponseEntity<CategoriaController> getById(@PathVariable long id){
		
		return categoriaRepository.findById(id)
		.map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<CategoriaController>> GetByTipo(@PathVariable String genero){
		
		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(genero));	
	}
	
	@PostMapping
	public ResponseEntity<CategoriaController> post (@RequestBody CategoriaController categoria){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaController> put (@RequestBody CategoriaController categoria){
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteId(@PathVariable long id) {
		
		categoriaRepository.deleteById(id);
	}
	
}