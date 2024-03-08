package br.com.fiap.cashflowpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.cashflowpro.model.Categoria;
import br.com.fiap.cashflowpro.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    // List<Categoria> repository = new ArrayList<>();

    @Autowired // CDI -- Injeção de Dependência
    CategoriaRepository repository;
    
    @GetMapping
    public List<Categoria> index(){
        return repository.findAll();
    }

    // @PostMapping
    // public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
    //     //binding
    //     log.info("cadastrando categoria: {}", categoria);
    //     repository.add(categoria);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<Categoria> get(@PathVariable Long id) {
    //     log.info("buscando categoria com id: {}", id);

    //     //stream
    //     var categoria = getCategoriaById(id);

    //     if (categoria.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok(categoria.get());
    // }

    // private Optional<Categoria> getCategoriaById(Long id) {
    //     var categoria = repository
    //                         .stream()
    //                         .filter(c -> c.id().equals(id))
    //                         .findFirst();
    //     return categoria;
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<Categoria> destroy(@PathVariable Long id){
    //     log.info("Apagando categoria: {}", id);
    //     var categoria = getCategoriaById(id);

    //     if (categoria.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     repository.remove(categoria.get());
    //     return ResponseEntity.noContent().build();
    // }
    

    // @PutMapping
    // public ResponseEntity<Categoria> update (
    // @PathVariable long id,
    // @RequestBody Categoria categoria){
    //     log.info("Atualizando categoria com id {} para {}", id, categoria);

    //     var categoriaEncontrada = getCategoriaById(id);

    //     if (categoriaEncontrada.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     var categoriaAtualizada = new Categoria(id, categoria.nome(), categoria.icone());
    //     repository.remove(categoriaEncontrada.get());
    //     repository.add(categoriaAtualizada);

    //     return ResponseEntity.ok(categoriaAtualizada);
    // }

}
