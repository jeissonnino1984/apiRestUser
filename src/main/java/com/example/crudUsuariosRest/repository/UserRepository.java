package com.example.crudUsuariosRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudUsuariosRest.entity.Usuarios;

public interface UserRepository extends JpaRepository<Usuarios, Integer>{
	
	

}
