package br.com.altamira.data.wbccad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.data.wbccad.model.Prdorc;

@Repository
@Transactional(readOnly = true)
public interface PrdorcRepository extends CrudRepository<Prdorc, String> {

	Prdorc findByProduto(String orcamento);
    
	@Query(value = "SELECT DISTINCT [WBCCAD].[dbo].[PRDORC].* FROM [WBCCAD].[dbo].[ORCCAB] INNER JOIN [WBCCAD].[dbo].[ORCDET] ON [WBCCAD].[dbo].[ORCCAB].numeroOrcamento = [WBCCAD].[dbo].[ORCDET].numeroOrcamento INNER JOIN [WBCCAD].[dbo].[PRDORC] ON [WBCCAD].[dbo].[ORCDET].ORCDET_CODIGO_ORI = [WBCCAD].[dbo].[PRDORC].Produto WHERE [WBCCAD].[dbo].[ORCCAB].numeroOrcamento = :orcamento /*ORDER BY [WBCCAD].[dbo].[PRDORC].Produto*/", nativeQuery = true)
	List<Prdorc> listarPrdorc(@Param("orcamento") String orcamento);
}