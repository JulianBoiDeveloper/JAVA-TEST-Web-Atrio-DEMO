package com.webatrio.project.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webatrio.project.webapp.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long>{

}
