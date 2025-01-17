package com.example.demo.adapter.gateway.interfaces.impl;


import com.example.demo.core.domain.Cliente;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.presenter.ClienteEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class RecuperarClienteAdapter implements RecuperarClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente execute(String documentoCliente) {
        return ClienteEntityMapper.INSTANCE.mapFrom(clienteRepository.findByCpf(documentoCliente).orElse(null));
    }

    @Override
    public Cliente recuperarPorId(String clienteId) {
        return ClienteEntityMapper.INSTANCE.mapFrom(clienteRepository.findById(UUID.fromString(clienteId)).orElse(null));
    }

}
