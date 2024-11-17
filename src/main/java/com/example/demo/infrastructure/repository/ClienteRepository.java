package com.example.demo.infrastructure.repository;


import com.example.demo.infrastructure.repository.entity.ClienteEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ClienteRepository extends CrudRepository<ClienteEntity, String> {

}
