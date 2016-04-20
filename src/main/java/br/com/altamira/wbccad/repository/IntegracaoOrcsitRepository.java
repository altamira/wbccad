package br.com.altamira.wbccad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.IntegracaoOrcsit;

@Repository
@Transactional(readOnly = true)
public interface IntegracaoOrcsitRepository extends CrudRepository<IntegracaoOrcsit, String> {
	
}