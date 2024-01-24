package com.webatrio.project.webapp.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webatrio.project.webapp.dto.JobDTO;
import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.repository.IJobRepository;
import com.webatrio.project.webapp.repository.IPersonRepository;

@Service
public class JobService {
	
    @Autowired
    private IJobRepository jobRepository;
	
    @Autowired
    private IPersonRepository personRepository;
    
    // Méthodes pour gérer les emplois
    public Job addJob(JobDTO jobDTO) throws Exception {
        Person person = personRepository.findById(jobDTO.getPersonId())
                .orElseThrow(() -> new Exception("Personne non trouvée"));
        
       
        Job job = new Job();
        
        job.setPersonne(person);
        job.setNomEntreprise(jobDTO.getNomEntreprise());
        job.setPoste(jobDTO.getPoste());
        job.setDateDebut(jobDTO.getDateDebut());
        job.setDateFin(jobDTO.getDateFin());
        
        
        	

        return jobRepository.save(job);
    }
    
    public List<Job> getJobsByPersonAndDateRange(Person personne, Date startDate, Date endDate) {
    	
    	List<Job> repository= jobRepository.findByPersonneAndDateDebutBetweenAndDateFinBetween(
                personne, startDate, endDate, startDate, endDate); 	
    	
        return repository;
    }	
}