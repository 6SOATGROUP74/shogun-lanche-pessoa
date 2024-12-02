package com.example.demo.adapter.controller;

import com.example.demo.ClienteCommon;
import com.example.demo.adapter.controller.request.cliente.ClienteRequest;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.exceptions.ClienteDuplicadoException;
import com.example.demo.exceptions.ClienteNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static com.example.demo.ClienteCommon.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    IncluirClienteUseCasePort incluirClienteUseCasePort;

    @Mock
    RecuperarClienteUseCasePort recuperarClienteUseCasePort;

    @InjectMocks
    ClienteController clienteController;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController)
                .setControllerAdvice(new CustomExceptionHandlers())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @Test
    void devePermitirIncluirCliente() throws Exception {

        ClienteRequest clienteRequest = ClienteCommon.factoryClienteRequest();

        when(incluirClienteUseCasePort.execute(any(Cliente.class)))
                .thenReturn(ClienteCommon.factoryCliente());

        mockMvc.perform(post("/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clienteRequest)))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(incluirClienteUseCasePort, times(1))
                .execute(any(Cliente.class));
    }

    @Test
    void deveLancarExcecao_QuandoClienteDuplicado() throws Exception {

        ClienteRequest clienteRequest = ClienteCommon.factoryClienteRequest();

        when(incluirClienteUseCasePort.execute(any(Cliente.class)))
                .thenThrow(ClienteDuplicadoException.class);

        mockMvc.perform(post("/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clienteRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest());
        verify(incluirClienteUseCasePort, times(1))
                .execute(any(Cliente.class));
    }

    @Test
    void devePermitirBuscarCliente() throws Exception {

        ClienteRequest clienteRequest = ClienteCommon.factoryClienteRequest();

        when(recuperarClienteUseCasePort.recuperarPorId(anyString()))
                .thenReturn(ClienteCommon.factoryCliente());

        mockMvc.perform(get("/v1/clientes/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(recuperarClienteUseCasePort, times(1))
                .recuperarPorId(anyString());
    }

    @Test
    void deveLancarExcecao_QuandoClienteNaoLocalizado() throws Exception {

        ClienteRequest clienteRequest = ClienteCommon.factoryClienteRequest();

        when(recuperarClienteUseCasePort.recuperarPorId(anyString()))
                .thenThrow(ClienteNotFoundException.class);

        mockMvc.perform(get("/v1/clientes/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        verify(recuperarClienteUseCasePort, times(1))
                .recuperarPorId(anyString());
    }





}