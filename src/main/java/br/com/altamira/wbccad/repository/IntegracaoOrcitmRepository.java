package br.com.altamira.wbccad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.IntegracaoOrcitm;

@Repository
@Transactional(readOnly = true)
public interface IntegracaoOrcitmRepository extends CrudRepository<IntegracaoOrcitm, String> {
	
	List<IntegracaoOrcitm> findByOrcnum(String orcamento);
	
	IntegracaoOrcitm findByOrcnumAndOrcitmAndGrpcodAndSubgrpcod(String orcamento, Integer item, Integer grupo, Integer subgrupo);
	
}