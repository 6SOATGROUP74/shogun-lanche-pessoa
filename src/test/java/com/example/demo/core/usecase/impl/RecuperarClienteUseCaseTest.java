package com.example.demo.core.usecase.impl;

import com.example.demo.ClienteCommon;
import com.example.demo.adapter.gateway.interfaces.impl.RecuperarClienteAdapter;
import com.example.demo.core.domain.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RecuperarClienteUseCaseTest {

    @Mock
    RecuperarClienteAdapter adapter;

    @InjectMocks
    RecuperarClienteUseCase recuperarClienteUseCase;

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
    void devePermitirRecuperarClientePeloCpf(){
        when(adapter.execute(anyString())).thenReturn(ClienteCommon.factoryCliente());

        final var result = recuperarClienteUseCase.execute("1232132132");

        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(adapter, times(1)).execute(anyString());

    }

    @Test
    void deveLancarExcecao_QuandoClienteNaoLocalizadoPorCpf(){
        when(adapter.execute(anyString())).thenReturn(null);
        assertThatThrownBy(() -> recuperarClienteUseCase.execute(anyString()));
    }

    @Test
    void devePermitirRecuperarClientePeloId(){
        when(adapter.recuperarPorId(anyString())).thenReturn(ClienteCommon.factoryCliente());

        final var result = recuperarClienteUseCase.recuperarPorId("");

        assertThat(result).isNotNull().isInstanceOf(Cliente.class);
        verify(adapter, times(1)).recuperarPorId(anyString());

    }

    @Test
    void deveLancarExcecao_QuandoClienteNaoLocalizadoPorId(){
        when(adapter.recuperarPorId(anyString())).thenReturn(null);
        assertThatThrownBy(() -> recuperarClienteUseCase.recuperarPorId(anyString()));
    }

}