package br.com.overall.training.usuario;

import br.com.overall.training.treino.Treino;

import java.math.BigDecimal;
import java.util.List;

public record UsuarioResponseDto(String user, BigDecimal peso, BigDecimal altura, BigDecimal imc, Integer idade, List<Treino>treinos) {
    public UsuarioResponseDto(Usuario usuario){
        this(usuario.getUser(), usuario.getPeso(), usuario.getAltura(), usuario.getImc(), usuario.getIdade(), usuario.getTreinos());
    }
}
