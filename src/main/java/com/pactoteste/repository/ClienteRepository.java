package com.pactoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pactoteste.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
