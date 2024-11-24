package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Cliente;

import java.util.UUID;

public class ClienteCommon {

    public static Cliente factoryCliente(){
        var cliente = new Cliente();
        cliente.setCpf("48265391832");
        cliente.setEmail("igor@igor.com");
        cliente.setIdCliente(UUID.randomUUID().toString());
        cliente.setDataCadastro("2024-01-01");

        return cliente;

    }
}
