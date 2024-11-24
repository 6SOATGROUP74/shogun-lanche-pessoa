package com.example.demo;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.controller.response.cliente.ClienteResponse;
import com.example.demo.core.domain.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static ClienteRequest factoryClienteRequest(){
        ClienteRequest clienteRequest = new ClienteRequest();
        clienteRequest.setCpf("76408565077");
        clienteRequest.setEmail("igor@igor.com");
        clienteRequest.setNome("igu");

        return clienteRequest;
    }

    public static ClienteResponse factoryClienteResponse(){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setCpf("76408565077");
        clienteResponse.setEmail("igor@igor.com");
        clienteResponse.setNome("igu");
        clienteResponse.setIdCliente(UUID.randomUUID().toString());
        clienteResponse.setDataCadastro("2024-01-01");

        return clienteResponse;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
