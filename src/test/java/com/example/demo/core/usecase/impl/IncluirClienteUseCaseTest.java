package com.example.demo.core.usecase.impl;

import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.impl.ClienteCommon;
import com.example.demo.adapter.gateway.interfaces.impl.IncluirClienteAdapter;
import com.example.demo.adapter.gateway.interfaces.impl.RecuperarClienteAdapter;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class IncluirClienteUseCaseTest {

    @Mock
    IncluirClienteAdapter adapter;

    @Mock
    RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    @InjectMocks
    IncluirClienteUseCase incluirClienteUseCase;

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
    void devePermitirIncluirUmCliente(){
        when(adapter.execute(any(Cliente.class)))
                .thenReturn(ClienteCommon.factoryCliente());

        when(recuperarClienteAdapterPort.execute(anyString()))
                .thenReturn(null);

        final var result = incluirClienteUseCase.execute(ClienteCommon.factoryCliente());
        assertThat(result).isNotNull().isInstanceOf(Cliente.class);

        verify(adapter, times(1)).execute(any(Cliente.class));
        verify(recuperarClienteAdapterPort, times(1)).execute(anyString());

    }

    @Test
    void deveLancarExcecao_AoLocalizarUmClienteEmBase(){

        when(recuperarClienteAdapterPort.execute(anyString()))
                .thenReturn(ClienteCommon.factoryCliente());

        assertThatThrownBy(() -> incluirClienteUseCase.execute(ClienteCommon.factoryCliente()));

        verify(adapter, times(0)).execute(any(Cliente.class));
        verify(recuperarClienteAdapterPort, times(1)).execute(anyString());

    }



}