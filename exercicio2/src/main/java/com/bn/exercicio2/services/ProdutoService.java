package com.bn.exercicio2.services;

import com.bn.exercicio2.models.ProdutoModel;
import com.bn.exercicio2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).get();
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        ProdutoModel novoProduto = produtoRepository.findById(id).get();
        novoProduto.setNome(produtoModel.getNome());
        novoProduto.setPreco(produtoModel.getPreco());
        novoProduto.setEstoque(produtoModel.getEstoque());
        return produtoRepository.save(novoProduto);
    }
}
