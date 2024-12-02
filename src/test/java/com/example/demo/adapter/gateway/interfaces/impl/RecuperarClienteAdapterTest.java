package com.example.demo.adapter.gateway.interfaces.impl;

import com.example.demo.core.domain.Cliente;
import com.example.demo.infrastructure.repository.ClienteRepository;
import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RecuperarClienteAdapterTest {

    @Mock
    ClienteRepository repository;

    @InjectMocks
    RecuperarClienteAdapter adapter;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirRecuperarUmclientePorCpf(){

        final var response = new ClienteEntity();
        response.setIdCliente(UUID.randomUUID());
        when(repository.findByCpf(anyString())).thenReturn(Optional.of(response));

        final var result = adapter.execute("");
        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(repository, times(1)).findByCpf(anyString());

    }

    @Test
    void devePermitirRecuperarUmclienteId(){

        final var response = new ClienteEntity();
        response.setIdCliente(UUID.randomUUID());
        when(repository.findById(any())).thenReturn(Optional.of(response));

        final var result = adapter.recuperarPorId(UUID.randomUUID().toString());
        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(repository, times(1)).findById(any());

    }

    @Test
    void deveRetornoNullParaIdNaoExistentes(){
        when(repository.findById(any())).thenReturn(Optional.empty());

        final var result = adapter.recuperarPorId(UUID.randomUUID().toString());
        assertThat(result).isNull();
        verify(repository, times(1)).findById(any());

    }
}