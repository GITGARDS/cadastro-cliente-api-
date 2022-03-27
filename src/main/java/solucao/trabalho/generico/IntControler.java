package solucao.trabalho.generico;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import solucao.trabalho.Cliente;

public interface IntControler<T> {

	@PostMapping(value = "/post")
	ResponseEntity<T> create(@RequestBody Cliente t);

	@PutMapping(value = "/put/{id}")
	ResponseEntity<T> update(@PathVariable Integer id, @RequestBody Cliente t);

	@DeleteMapping(value = "/delete/{id}")
	ResponseEntity<T> delete(@PathVariable Integer id);

	@GetMapping(value = "/getAll")
	ResponseEntity<List<T>> localizarTodos();

	@GetMapping(value = "/getOne/{id}")
	ResponseEntity<T> localizarPorId(@PathVariable Integer id);

	@GetMapping(value = "/getAllp/{pageNumber}/{pageSize}")
	ResponseEntity<Page<T>> findAllPg(@PathVariable Integer pageNumber, @PathVariable Integer pageSize);

	@GetMapping(value = "/getAllp/{pageNumber}/{pageSize}/{sortProperty}")
	ResponseEntity<Page<T>> findAllPg(@PathVariable Integer pageNumber, @PathVariable Integer pageSize,
			@PathVariable String sortProperty);

}
