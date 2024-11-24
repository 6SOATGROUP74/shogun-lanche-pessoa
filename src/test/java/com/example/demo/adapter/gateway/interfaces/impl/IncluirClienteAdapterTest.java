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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class IncluirClienteAdapterTest {

    @Mock
    ClienteRepository repository;

    @InjectMocks
    IncluirClienteAdapter adapter;

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
    void devePermitirIncluirCliente(){
        when(repository.save(any(ClienteEntity.class)))
                .thenAnswer(item -> item.getArgument(0));
        final var result = adapter.execute(ClienteCommon.factoryCliente());

        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
    }

}