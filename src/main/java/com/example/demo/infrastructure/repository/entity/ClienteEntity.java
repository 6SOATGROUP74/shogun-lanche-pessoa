package com.example.demo.infrastructure.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@DynamoDBTable(tableName = "tb_cliente")
public class ClienteEntity {

    @Id
    @DynamoDBHashKey(attributeName = "id_cliente")
    private UUID idCliente;

    @Id
    @DynamoDBAttribute(attributeName = "cpf")
    private String cpf;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "data_cadastro")
    private String dataCadastro;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

}
