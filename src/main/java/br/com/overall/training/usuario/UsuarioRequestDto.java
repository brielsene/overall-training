package br.com.overall.training.usuario;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

public record UsuarioRequestDto(

        @NotBlank

        String user,
        @NotBlank
        String senha


) {
}
