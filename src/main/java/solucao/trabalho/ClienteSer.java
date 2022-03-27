package solucao.trabalho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import solucao.trabalho.generico.IntServicos;

@Service
public class ClienteSer implements IntServicos<Cliente> {

	@Autowired
	private ClienteRep rep;

	@Override
	public Cliente create(Cliente t) {
		Cliente find = this.rep.save(t);
		return find;
	}

	@Override
	public Cliente update(Integer id, Cliente t) {
		Cliente find = this.findOne(id);
		Cliente upd = this.rep.save(t);
		return upd;
	}

	@Override
	public Cliente delete(Integer id) {
		Cliente find = this.findOne(id);
		this.rep.delete(find);
		return find;
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> finds = this.rep.findAll();
		return finds;
	}

	@Override
	public Cliente findOne(Integer id) {
		return this.rep.findById(id).orElseThrow();
	}

	@Override
	public Page<Cliente> findAllPg(Integer pageNumber, Integer pageSize, String sortProperty) {
		Pageable pageable = null;
		if (null != sortProperty) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
		} else {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "id");
		}
		return this.rep.findAll(pageable);
	}

}
