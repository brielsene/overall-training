package br.com.overall.training.refeicao;

import br.com.overall.training.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Refeicao")
@Table(name = "refeicao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime time;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
