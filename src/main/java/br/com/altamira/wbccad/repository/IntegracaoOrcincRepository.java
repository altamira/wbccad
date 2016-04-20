package br.com.altamira.wbccad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.IntegracaoOrcinc;

@Repository
@Transactional(readOnly = true)
public interface IntegracaoOrcincRepository extends CrudRepository<IntegracaoOrcinc, String> {
	
}