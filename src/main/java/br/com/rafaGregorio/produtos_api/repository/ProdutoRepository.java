package br.com.rafaGregorio.produtos_api.repository;

import br.com.rafaGregorio.produtos_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
