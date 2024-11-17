package com.example.demo.infrastructure.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@DynamoDBTable(tableName = "tb_pessoa")
public class ClienteEntity implements Serializable {

    @Id
    @DynamoDBHashKey(attributeName = "cpf")
    private String cpf;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "data_cadastro")
    private String dataCadastro;

    @DynamoDBAttribute(attributeName = "email")
    private String email;

}
