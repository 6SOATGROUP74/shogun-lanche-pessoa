package com.example.demo.infrastructure.repository;


import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import java.util.Optional;
import java.util.UUID;

@EnableScan
public interface ClienteRepository extends DynamoDBCrudRepository<ClienteEntity, UUID> {

    Optional<ClienteEntity> findByCpf(String cpf);

}
