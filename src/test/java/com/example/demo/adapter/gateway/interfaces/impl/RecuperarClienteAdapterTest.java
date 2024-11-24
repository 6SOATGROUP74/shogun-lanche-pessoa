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
        when(repository.findByCpf(anyString())).thenReturn(new ClienteEntity());

        final var result = adapter.execute("");
        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(repository, times(1)).findByCpf(anyString());

    }

    @Test
    void devePermitirRecuperarUmclienteId(){
        when(repository.findById(anyString())).thenReturn(Optional.of(new ClienteEntity()));

        final var result = adapter.recuperarPorId("");
        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(repository, times(1)).findById(anyString());

    }

    @Test
    void deveRetornoNullParaIdNaoExistentes(){
        when(repository.findById(anyString())).thenReturn(Optional.empty());

        final var result = adapter.recuperarPorId("");
        assertThat(result).isNull();
        verify(repository, times(1)).findById(anyString());

    }

}