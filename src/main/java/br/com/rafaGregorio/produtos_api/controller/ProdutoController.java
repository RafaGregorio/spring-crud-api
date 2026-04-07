package br.com.rafaGregorio.produtos_api.controller;

import br.com.rafaGregorio.produtos_api.dto.mapper.ProdutoDTOMapper;
import br.com.rafaGregorio.produtos_api.dto.request.ProdutoRequestDTO;
import br.com.rafaGregorio.produtos_api.dto.response.ProdutoResponseDTO;
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
    public ResponseEntity<Void> salvarProduto(@RequestBody ProdutoRequestDTO dto){
        Produto produto = ProdutoDTOMapper.toEntity(dto);
        service.salvarProduto(produto);

        return ResponseEntity.created(URI.create("/produtos/" + produto.getId())).build();
    };

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos(){
        List<Produto> produtos = service.buscarTodosProdutos();

        List<ProdutoResponseDTO> response = produtos.stream()
                .map(ProdutoDTOMapper::responseDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id){
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(ProdutoDTOMapper.responseDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPorId(@PathVariable Long id, @RequestBody ProdutoRequestDTO dto){
        Produto produto = ProdutoDTOMapper.toEntity(dto);

        service.atualizarProdutoPorId(produto, id);
        return ResponseEntity.noContent().build();
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
      service.deletarProduto(id);
      return ResponseEntity.noContent().build();
    };
}
