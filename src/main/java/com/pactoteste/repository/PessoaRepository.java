package com.pactoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pactoteste.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>{ 
	
	@Query("SELECT COUNT(u) > 0 FROM PessoaEntity u WHERE u.cpf = :cpf")
    boolean existeCPF(@Param("cpf") String cpf);


}
