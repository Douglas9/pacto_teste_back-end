package com.pactoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pactoteste.entity.TelefoneEntity;

public interface TelefoneRepository extends JpaRepository<TelefoneEntity, Long>{ 

}
