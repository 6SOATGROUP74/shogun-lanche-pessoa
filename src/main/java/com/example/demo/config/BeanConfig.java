package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.core.usecase.impl.IncluirClienteUseCase;
import com.example.demo.core.usecase.impl.RecuperarClienteUseCase;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public IncluirClienteUseCasePort incluirClienteUseCasePort(IncluirClienteAdapterPort incluirClienteAdapterPort,
                                                               RecuperarClienteAdapterPort recuperarClienteAdapterPort
                                                               ) {
        return new IncluirClienteUseCase(recuperarClienteAdapterPort, incluirClienteAdapterPort);
    }

    @Bean
    public RecuperarClienteUseCasePort recuperarClienteUseCasePort(RecuperarClienteAdapterPort recuperarClienteAdapterPort) {
        return new RecuperarClienteUseCase(recuperarClienteAdapterPort);
    }
}
