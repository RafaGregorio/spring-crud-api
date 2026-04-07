package br.com.rafaGregorio.produtos_api.service;

import br.com.rafaGregorio.produtos_api.entity.Produto;
import br.com.rafaGregorio.produtos_api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> buscarTodosProdutos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    public Produto salvarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void atualizarProdutoPorId(Produto produto, Long id){
        Produto produtoEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
        if (produto.getName() != null) {
            produtoEntity.setName(produto.getName());
        }
        if (produto.getDescription() != null) {
            produtoEntity.setDescription(produto.getDescription());
        }
        if (produto.getPrice() != null) {
            produtoEntity.setPrice(produto.getPrice());
        }
        if (produto.getQuantity() != null) {
            produtoEntity.setQuantity(produto.getQuantity());
        }
        repository.save(produtoEntity);
    };

    public void deletarProduto(Long id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        repository.deleteById(id);
    }
 }
