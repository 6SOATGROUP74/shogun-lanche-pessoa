package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.adapter.gateway.interfaces.pedido.PedidoEmPreparacaoAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.demo.core.domain.StatusPedido.EM_PREPARACAO;

@AllArgsConstructor
@Component
public class PedidoEmPreparacaoAdapter implements PedidoEmPreparacaoAdapterPort {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido execute(Long idPedido) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(idPedido).orElseThrow();
        pedidoEntity.setEtapa(EM_PREPARACAO.name());
        PedidoEntity pedidoAlterado = pedidoRepository.save(pedidoEntity);
        return PedidoEntityMapper.INSTANCE.mapFrom(pedidoAlterado);
    }
}
