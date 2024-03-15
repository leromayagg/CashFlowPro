package br.com.fiap.cashflowpro.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cashflowpro.model.Movimentacao;
import br.com.fiap.cashflowpro.repository.MovimentacaoRepository;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    


    
    @Autowired
    MovimentacaoRepository repository;

    @PostMapping
    @ResponseStatus(CREATED)
    public Movimentacao create(@RequestBody Movimentacao movimentacao){
        
        return repository.save(movimentacao);
    };


}
