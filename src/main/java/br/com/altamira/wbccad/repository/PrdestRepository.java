package br.com.altamira.wbccad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.Prdest;

@Repository
@Transactional(readOnly = true)
public interface PrdestRepository extends CrudRepository<Prdest, String> {

	List<Prdest> findAllByIdPrdorccodigopai(String codigo);
	
	List<Prdest> findAllByIdPrdorccodigofilho(String codigo);
}