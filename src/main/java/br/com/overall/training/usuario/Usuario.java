package br.com.overall.training.usuario;

import br.com.overall.training.refeicao.Refeicao;
import br.com.overall.training.treino.Treino;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false, unique = true)
    private String user;
    private String senha;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal imc;
    private Integer idade;
    @OneToMany(mappedBy = "usuario")
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Refeicao> refeicoes;

    @OneToMany(mappedBy = "usuario")
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Treino>treinos;

    public Usuario(UsuarioRequestDto data){
        this.user = data.user();
        this.senha = data.senha();
    }

    public Usuario (Long id){
        this.id = id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
