package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.cliente.*;
import com.example.demo.core.usecase.impl.IncluirClienteUseCase;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeanConfigTest {

    private BeanConfig beanConfig;

    @Mock
    private IncluirClienteAdapterPort incluirClienteAdapterPort;

    @Mock
    private RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        beanConfig = new BeanConfig();
    }

    @Test
    void testIncluirClienteUseCasePort() {
        IncluirClienteUseCasePort incluirClienteUseCasePort = beanConfig.incluirClienteUseCasePort(incluirClienteAdapterPort, recuperarClienteAdapterPort);

        assertNotNull(incluirClienteUseCasePort);
    }

    @Test
    void testRecuperarClienteUseCasePort() {
        RecuperarClienteUseCasePort recuperarClienteUseCasePort = beanConfig.recuperarClienteUseCasePort(recuperarClienteAdapterPort);

        assertNotNull(recuperarClienteUseCasePort);
    }
}
