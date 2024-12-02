package com.example.demo;

import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.controller.response.cliente.ClienteResponse;
import com.example.demo.core.domain.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;
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

    public static String gerarCPF() {
        Random random = new Random();

        // Gera os 9 primeiros dígitos do CPF
        int[] numeros = new int[9];
        for (int i = 0; i < 9; i++) {
            numeros[i] = random.nextInt(10);
        }

        // Calcula o primeiro dígito verificador
        int primeiroDigito = calcularDigitoVerificador(numeros, 10);

        // Adiciona o primeiro dígito verificador no array
        int[] numerosComPrimeiroDigito = new int[10];
        System.arraycopy(numeros, 0, numerosComPrimeiroDigito, 0, numeros.length);
        numerosComPrimeiroDigito[9] = primeiroDigito;

        // Calcula o segundo dígito verificador
        int segundoDigito = calcularDigitoVerificador(numerosComPrimeiroDigito, 11);

        // Monta o CPF em formato String
        StringBuilder cpf = new StringBuilder();
        for (int numero : numeros) {
            cpf.append(numero);
        }
        cpf.append(primeiroDigito).append(segundoDigito);

        return cpf.toString();
    }

    private static int calcularDigitoVerificador(int[] numeros, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i] * (pesoInicial - i);
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
