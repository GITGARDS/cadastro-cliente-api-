package solucao.trabalho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/api/cadastros/cliente" })
public class ClienteCtrl {

	@Autowired
	private ClienteSer ser;

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente t) {
		Cliente find = this.ser.create(t);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente t) {
		Cliente find = this.ser.update(id, t);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
		Cliente find = this.ser.delete(id);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Cliente>> localizarTodos() {
		List<Cliente> finds = this.ser.findAll();
		return new ResponseEntity<List<Cliente>>(finds, HttpStatus.OK);
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Cliente> localizarPorId(@PathVariable Integer id) {
		Cliente find = this.ser.findOne(id);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);

	}

	@GetMapping(value = "/all/{pageNumber}/{pageSize}")
	public ResponseEntity<Page<Cliente>> findAllPg(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
		Page<Cliente> page = this.ser.findAllPg(pageNumber, pageSize, null);
		return new ResponseEntity<Page<Cliente>>(page, HttpStatus.OK);
	}

	@GetMapping(value = "/all/{pageNumber}/{pageSize}/{sortProperty}")
	public ResponseEntity<Page<Cliente>> findAllPg(@PathVariable Integer pageNumber, @PathVariable Integer pageSize,
			@PathVariable String sortProperty) {
		Page<Cliente> page = this.ser.findAllPg(pageNumber, pageSize, sortProperty);
		return new ResponseEntity<Page<Cliente>>(page, HttpStatus.OK);

	}

}
