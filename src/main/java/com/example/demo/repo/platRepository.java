package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.plat;

@RepositoryRestResource
@CrossOrigin("*")
public interface platRepository extends JpaRepository<plat, Long>{

}
