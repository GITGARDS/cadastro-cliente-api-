package solucao.trabalho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import solucao.trabalho.generico.IntControler;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/api/cadastros/cliente" })
public class ClienteCtrl implements IntControler<Cliente> {

	@Autowired
	private ClienteSer ser;

	public ResponseEntity<Cliente> create(Cliente t) {
		Cliente find = this.ser.create(t);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	public ResponseEntity<Cliente> update(Integer id, Cliente t) {
		Cliente find = this.ser.update(id, t);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	public ResponseEntity<Cliente> delete(Integer id) {
		Cliente find = this.ser.delete(id);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);
	}

	public ResponseEntity<List<Cliente>> localizarTodos() {
		List<Cliente> finds = this.ser.findAll();
		return new ResponseEntity<List<Cliente>>(finds, HttpStatus.OK);
	}

	public ResponseEntity<Cliente> localizarPorId(Integer id) {
		Cliente find = this.ser.findOne(id);
		return new ResponseEntity<Cliente>(find, HttpStatus.OK);

	}

	public ResponseEntity<Page<Cliente>> findAllPg(Integer pageNumber, Integer pageSize) {
		Page<Cliente> page = this.ser.findAllPg(pageNumber, pageSize, null);
		return new ResponseEntity<Page<Cliente>>(page, HttpStatus.OK);
	}

	public ResponseEntity<Page<Cliente>> findAllPg(Integer pageNumber,Integer pageSize,
			@PathVariable String sortProperty) {
		Page<Cliente> page = this.ser.findAllPg(pageNumber, pageSize, sortProperty);
		return new ResponseEntity<Page<Cliente>>(page, HttpStatus.OK);

	}

}
