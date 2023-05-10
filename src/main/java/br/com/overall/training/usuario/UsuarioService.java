package br.com.overall.training.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrar(UsuarioRequestDto data){
        Usuario usuario = new Usuario(data);
        usuarioRepository.save(usuario);

    }

    public UsuarioResponseDto findByUser(String user){
        Usuario byUser = usuarioRepository.findByUser(user);
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto(byUser);
        return usuarioResponseDto;

    }
}
