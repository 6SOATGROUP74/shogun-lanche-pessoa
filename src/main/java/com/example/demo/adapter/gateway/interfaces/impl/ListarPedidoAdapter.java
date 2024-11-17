package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPedidoAdapter implements ListarPedidosAdapterPort {

    private final PedidoRepository repository;

    public ListarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return PedidoEntityMapper.INSTANCE.mapFrom(repository.findAll());
    }

    @Override
    public List<Pedido> listarPedidosOrdenados() {
        return PedidoEntityMapper.INSTANCE.mapFrom(repository.ordenaPedidos());
    }

    @Override
    public Pedido buscarPedidoPorCodReferencia(String codReferencia) {
        return PedidoEntityMapper.INSTANCE.mapFrom(repository.findByCodReferenciaPedido(codReferencia));
    }
}
