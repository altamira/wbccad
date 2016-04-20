package br.com.altamira.wbccad.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.altamira.wbccad.model.*;

@Repository
@Transactional(readOnly = true)
public interface OrclstRepository extends CrudRepository<Orclst, String> {

    Orclst findByOrclstNumero(String orcamento);
    List<Orclst> findAllByOrderByOrclstNumeroDesc(Pageable pageable);
}