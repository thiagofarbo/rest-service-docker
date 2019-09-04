package br.com.example.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.docker.model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long>{

}
