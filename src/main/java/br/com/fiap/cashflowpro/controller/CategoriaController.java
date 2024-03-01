package br.com.fiap.cashflowpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.cashflowpro.model.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categoria> repository = new ArrayList<>();
    
    @RequestMapping(method = RequestMethod.GET , path = "/categoria")
    @ResponseBody
    public List<Categoria> index(){
        return repository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/categoria")
    @ResponseBody
    //@ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        //binding
        log.info("cadastrando categoria: {}", categoria);
        repository.add(categoria);
        return ResponseEntity.status(201).body(categoria);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categoria/{id}")
    @ResponseBody
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        log.info("buscando categoria com id: {}", id);

        //stream
        var categoria = repository
                            .stream()
                            .filter(c -> c.id().equals(id))
                            .findFirst();

        if (categoria.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(categoria.get());
    }
    
}
