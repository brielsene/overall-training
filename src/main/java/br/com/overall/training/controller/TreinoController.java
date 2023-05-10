package br.com.overall.training.controller;

import br.com.overall.training.treino.TreinoRequestDto;
import br.com.overall.training.treino.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treino")
public class TreinoController {
    @Autowired
    private TreinoService service;

    @PostMapping
    public void cadastrar(@RequestBody @Valid TreinoRequestDto data){
        service.cadastrarTreino(data);
    }
}
