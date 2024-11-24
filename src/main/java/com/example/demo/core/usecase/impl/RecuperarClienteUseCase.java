package com.example.demo.core.usecase.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.exceptions.ClienteNotFoundException;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class RecuperarClienteUseCase implements RecuperarClienteUseCasePort {

    private static final Logger logger = LogManager.getLogger(RecuperarClienteUseCase.class);

    private final RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    public RecuperarClienteUseCase(RecuperarClienteAdapterPort recuperarClienteAdapterPort) {
        this.recuperarClienteAdapterPort = recuperarClienteAdapterPort;
    }

    @Override
    public Cliente execute(String documentoCliente) {
        logger.info("m=execute, status=init,  msg=Recuperando cliente por documento, documentoCliente={}", documentoCliente);
        final var auxDocumento = documentoCliente.replaceAll("\\D", "");
        final var result = recuperarClienteAdapterPort.execute(documentoCliente);

        if(Objects.isNull(result)){
            logger.error("m=execute, status=failure,  msg=Cliente não encontrado pelo documento informado, documentoCliente={}", documentoCliente);
            throw new ClienteNotFoundException("Cliente não localizado na base de dados.");
        }
        return result;
    }

    public Cliente recuperarPorId(String clienteId) throws ClienteNotFoundException {
        logger.info("m=recuperarPorId, msg=Recuperando cliente por clienteId, clienteId={}", clienteId);

        final var result = recuperarClienteAdapterPort.recuperarPorId(clienteId);

        if(Objects.isNull(result)){
            logger.error("m=recuperarPorId, status=failure,  msg=Cliente não encontrado pelo id informado, clienteId={}", clienteId);
            throw new ClienteNotFoundException("Cliente não localizado na base de dados.");
        }

        return result;
    }
    
}
