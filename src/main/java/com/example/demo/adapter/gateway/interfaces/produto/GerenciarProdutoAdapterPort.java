package com.example.demo.adapter.gateway.interfaces.produto;

import java.util.List;

public interface GerenciarProdutoAdapterPort {
    Produto salvar(Produto produto);
    List<Produto> buscarProdutoPorCategoria(String categoria);
    Produto buscarProdutoPorId(Long id);
}
