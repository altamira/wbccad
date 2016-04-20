package br.com.altamira.wbccad.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.OrcDet;

@Repository
@Transactional(readOnly = true)
public interface OrcDetRepository extends CrudRepository<OrcDet, String> {

	Long countByNumeroOrcamento(String numero);
	
	List<OrcDet> findAllByNumeroOrcamento(String numero);
	
	List<OrcDet> findAllByNumeroOrcamentoAndOrcdetItem(String numero, String item);
	
    List<OrcDet> findAllByNumeroOrcamentoAndOrcdetItemAndOrcdetGrupoAndOrcdetSubgrupo(String orcamento, String item, Integer grupo, String subgrupo);
}