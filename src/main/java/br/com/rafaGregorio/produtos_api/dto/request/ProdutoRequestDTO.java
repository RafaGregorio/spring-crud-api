package br.com.rafaGregorio.produtos_api.dto.request;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String name,
        String description,
        BigDecimal price,
        Integer quantity
) {}
