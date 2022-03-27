package solucao.trabalho.generico;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IntServicos<T> {

	T create(T t);

	T update(Integer id, T t);

	T delete(Integer id);

	List<T> findAll();

	T findOne(Integer id);
	
	Page<T> findAllPg(Integer pageNumber, Integer pageSize, String sortProperty);


}
