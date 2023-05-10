package br.com.overall.training.treino;

import br.com.overall.training.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treino")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treino {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Treino(TreinoRequestDto data){
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.usuario = new Usuario(data.id());
    }
}
