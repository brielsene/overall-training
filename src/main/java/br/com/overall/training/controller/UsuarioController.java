package br.com.overall.training.controller;

import br.com.overall.training.infra.configuration.TokenService;
import br.com.overall.training.usuario.Usuario;
import br.com.overall.training.usuario.UsuarioRequestDto;
import br.com.overall.training.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @PostMapping
//    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioRequestDto data){
//        service.cadastrar(data);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping
    public String login (@RequestBody @Valid UsuarioRequestDto data){
         UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                 new UsernamePasswordAuthenticationToken(data.user(), data.senha());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);



    }
}
