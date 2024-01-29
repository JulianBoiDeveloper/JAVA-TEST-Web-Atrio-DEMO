package com.webatrio.project.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webatrio.project.webapp.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long>{
	@Query("SELECT p FROM Person p ORDER BY p.nom ASC, p.prenom ASC")
    List<Person> findAllByOrderByNomAscPrenomAsc();
}
