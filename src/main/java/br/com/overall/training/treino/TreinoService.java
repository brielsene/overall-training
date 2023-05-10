package br.com.overall.training.treino;

import br.com.overall.training.usuario.Usuario;
import br.com.overall.training.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarTreino(TreinoRequestDto data){
        Treino treino = new Treino(data);
        Optional<Usuario> byId = usuarioRepository.findById(treino.getUsuario().getId());
        if(byId.isPresent()){
            treino.setUsuario(byId.get());
            repository.save(treino);
        }else{
            throw new RuntimeException("Usuario não encontrado");
        }

    }
}
