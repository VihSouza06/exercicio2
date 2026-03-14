package com.bn.exercicio2.repositories;

import com.bn.exercicio2.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
