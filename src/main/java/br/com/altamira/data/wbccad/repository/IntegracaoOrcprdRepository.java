package br.com.altamira.data.wbccad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.data.wbccad.model.IntegracaoOrcprd;

@Repository
@Transactional(readOnly = true)
public interface IntegracaoOrcprdRepository extends CrudRepository<IntegracaoOrcprd, String> {
	
	List<IntegracaoOrcprd> findAllByOrcnum(String numero);
	
	@Query(value = "SELECT ORCNUM, ORCITM, 0 AS GRPCOD, 0 AS SUBGRPCOD, PRDCOD, CORCOD, PRDDSC, SUM(ORCQTD) AS ORCQTD, SUM(ORCTOT) AS ORCTOT, SUM(ORCPES) AS ORCPES, ROW_NUMBER() OVER(ORDER BY ORCNUM DESC) AS IDINTEGRACAO_ORCPRD FROM INTEGRACAO_ORCPRD WHERE ORCNUM = :orcamento AND ORCITM = :item GROUP BY ORCNUM, ORCITM, PRDCOD, CORCOD, PRDDSC", nativeQuery = true)
	List<IntegracaoOrcprd> findByOrcnumAndOrcitm(String orcamento, Integer item);
}