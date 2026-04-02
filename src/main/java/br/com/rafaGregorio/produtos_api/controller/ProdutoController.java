package br.com.rafaGregorio.produtos_api.controller;

import br.com.rafaGregorio.produtos_api.entity.Produto;
import br.com.rafaGregorio.produtos_api.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    public ResponseEntity<Produto> buscarProdutoPorId(@RequestBody Long id){
      return ResponseEntity.ok(service.buscarPorId(id));
    };

    @PutMapping("/{id}")
    public ResponseEntity<Void> produtoAtualizadoPorId(@PathVariable Long id, @RequestBody Produto produto){
        service.atualizarProdutoPorId(produto, id);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/{name")
    public ResponseEntity<Void> deletarProdutoPorNome(@PathVariable String name){
      service.deletarProdutoPorNome(name);
      return ResponseEntity.noContent().build();
    };
}
