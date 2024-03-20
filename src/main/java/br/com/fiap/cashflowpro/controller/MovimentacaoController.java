package br.com.fiap.cashflowpro.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.cashflowpro.model.Movimentacao;
import br.com.fiap.cashflowpro.repository.MovimentacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    
    @Autowired
    MovimentacaoRepository repository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Movimentacao create(@RequestBody @Valid Movimentacao movimentacao){
        
        return repository.save(movimentacao);
    };


}
