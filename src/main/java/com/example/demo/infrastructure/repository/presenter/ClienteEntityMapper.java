package com.example.demo.infrastructure.repository.presenter;

import com.example.demo.core.domain.Cliente;
import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Mapper(imports = {LocalDateTime.class, UUID.class})
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    @Mapping(target = "dataCadastro", expression = "java(dataHoraAtual())")
    @Mapping(target = "idCliente", expression = "java(UUID.randomUUID())")
    ClienteEntity mapFrom(Cliente cliente);

    @Mapping(target = "dataCadastro", source = "dataCadastro")
    @Mapping(target = "idCliente", expression = "java(cliente.getIdCliente().toString())")
    Cliente mapFrom(ClienteEntity cliente);


    default String dataHoraAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
