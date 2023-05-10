package br.com.overall.training.treino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TreinoRequestDto(
        @NotBlank

        String nome,

        String descricao,
        @NotNull
        Long id) {
}
