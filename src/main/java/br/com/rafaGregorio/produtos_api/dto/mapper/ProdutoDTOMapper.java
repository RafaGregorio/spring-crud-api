package br.com.rafaGregorio.produtos_api.dto.mapper;

import br.com.rafaGregorio.produtos_api.dto.request.ProdutoRequestDTO;
import br.com.rafaGregorio.produtos_api.dto.response.ProdutoResponseDTO;
import br.com.rafaGregorio.produtos_api.entity.Produto;

public class ProdutoDTOMapper {

    public static Produto toEntity(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setName(dto.name());
        produto.setDescription(dto.description());
        produto.setPrice(dto.price());
        produto.setQuantity(dto.quantity());
        return produto;
    }

    public static ProdutoResponseDTO responseDTO(Produto produto){
        return new ProdutoResponseDTO(
                produto.getName(),
                produto.getDescription(),
                produto.getPrice()
        );
    }
}
