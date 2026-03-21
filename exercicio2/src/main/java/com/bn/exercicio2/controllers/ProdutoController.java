package com.bn.exercicio2.controllers;

import com.bn.exercicio2.models.ProdutoModel;
import com.bn.exercicio2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>>findAll(){
        List<ProdutoModel> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarProdutoPorId(@PathVariable Long id){
        ProdutoModel produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel produtoCriado = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produtoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarLivro
            (@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel produtoAtualizado = produtoService.atualizarProduto(id, produtoModel);
        return ResponseEntity.ok(produtoAtualizado);
    }
}
