package br.com.rafaGregorio.produtos_api.repository;

import br.com.rafaGregorio.produtos_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Transactional
    long deleteByIdAndName(Long id, String name);
}
