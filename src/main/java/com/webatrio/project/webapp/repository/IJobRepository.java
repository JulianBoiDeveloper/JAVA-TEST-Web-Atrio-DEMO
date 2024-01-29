package com.webatrio.project.webapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;

public interface IJobRepository extends JpaRepository<Job, Long>{
	 List<Job> findByPersonneAndDateDebutBetweenAndDateFinBetween(
		        Person personne, Date dateDebut, Date dateFin, Date dateDebut1, Date dateFin1);
	 List<Job> findByNomEntreprise(String nomEntreprise);
	 List<Job> findByPersonneId(Long personneId);
}
