package com.example.demo.infrastructure.repository;


import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

public interface ClienteRepository extends DynamoDBCrudRepository<ClienteEntity, String> {

    ClienteEntity findByCpf(String cpf);

}
