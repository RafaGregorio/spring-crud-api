package br.com.rafaGregorio.produtos_api.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProdutoResponseDTO(
        String name,
        String description,
        BigDecimal price
) {}

