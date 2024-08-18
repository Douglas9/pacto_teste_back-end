package com.pactoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pactoteste.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long>{

}
