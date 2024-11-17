package com.example.demo.config;

import com.example.demo.adapter.gateway.interfaces.cliente.IncluirClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.cliente.RecuperarClienteAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pagamento.BuscarPagamentoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pagamento.SalvarPagamentoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.AtualizarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.BuscarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.ListarPedidosAdapterPort;
import com.example.demo.adapter.gateway.interfaces.pedido.SalvarPedidoAdapterPort;
import com.example.demo.adapter.gateway.interfaces.produto.GerenciarProdutoAdapterPort;
import com.example.demo.core.usecase.impl.IncluirClienteUseCase;
import com.example.demo.core.usecase.impl.RecuperarClienteUseCase;
import com.example.demo.core.usecase.interfaces.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.cliente.RecuperarClienteUseCasePort;
import com.example.demo.core.usecase.interfaces.pagamento.AlterarStatusPagamentoUseCasePort;
import com.example.demo.core.usecase.interfaces.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pagamento.ValidarPagamentoPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.AlterarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.BuscarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.CriarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.ListarPedidosUseCasePort;
import com.example.demo.core.usecase.interfaces.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.usecase.interfaces.produto.GerenciarProdutoUseCasePort;
import com.example.demo.infrastructure.integration.pagbank.PagarPedidoPagbankAdapter;
import com.example.demo.infrastructure.integration.pagbank.ProcessaStatusPagamentoPagbankAdapter;
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
