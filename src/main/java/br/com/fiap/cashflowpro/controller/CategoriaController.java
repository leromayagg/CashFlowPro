package br.com.fiap.cashflowpro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.cashflowpro.model.Categoria;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Categoria> repository = new ArrayList<>();
    
    @GetMapping
     public List<Categoria> index(){
        return repository;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        //binding
        log.info("cadastrando categoria: {}", categoria);
        repository.add(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        log.info("buscando categoria com id: {}", id);

        //stream
        var categoria = getCategoriaById(id);

        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria.get());
    }

    private Optional<Categoria> getCategoriaById(Long id) {
        var categoria = repository
                            .stream()
                            .filter(c -> c.id().equals(id))
                            .findFirst();
        return categoria;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> destroy(@PathVariable Long id){
        log.info("Apagando categoria: {}", id);
        repository.removeIf(c -> c.id().equals(id));
        return ResponseEntity.noContent().build();
    }
    

    @PutMapping
    public ResponseEntity<Categoria> update (@PathVariable long id,
     @RequestBody Categoria categoria){
        log.info("Atualizando categoria com id {} para {}", id, categoria);

        var categoriaEncontrada = getCategoriaEncontrada(id);

        if (categoriaEncontrada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var categoriaAtualizada = new Categoria(id, categoria.nome(), categoria.icone());
        repository.remove(categoriaEncontrada.get());
        repository.add(categoriaAtualizada);

        return ResponseEntity.ok().build();
    }

    private Optional<Categoria> getCategoriaEncontrada(long id) {
        var categoriaEncontrada = repository
                            .stream()
                            .filter(c -> c.id().equals(id))
                            .findFirst();
        return categoriaEncontrada;
    }


}
