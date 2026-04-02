package br.com.rafaGregorio.produtos_api.controller;

import br.com.rafaGregorio.produtos_api.entity.Produto;
import br.com.rafaGregorio.produtos_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto){
        service.salvarProduto(produto);
        return ResponseEntity.created(URI.create("/produtos/" + produto.getId())).build();
    };

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = service.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/buscar /{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> produtoAtualizadoPorId(@PathVariable Long id, @RequestBody Produto produto){
        service.atualizarProdutoPorId(produto, id);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/{id}/{name}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id ,@PathVariable String name){
      service.deletarProduto(id, name);
      return ResponseEntity.noContent().build();
    };
}
