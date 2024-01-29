package com.webatrio.project.webapp.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webatrio.project.webapp.dto.JobDTO;
import com.webatrio.project.webapp.dto.PersonDTO;
import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.repository.IJobRepository;
import com.webatrio.project.webapp.repository.IPersonRepository;

@Service
public class PersonService {
 
	
	@Autowired 
    private IPersonRepository personRepository;
	
	@Autowired 
    private IJobRepository jobRepository;
	
	
	
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
            .orElse(null); 
    }
    
    public Person savePersonne(Person personne) throws Exception {
        if (isAgeValid(personne.getDateDeNaissance())) {
            return personRepository.save(personne);
        } else {
            throw new Exception("La personne doit avoir moins de 150 ans.");
        }
    }
    
    private boolean isAgeValid(Date dateDeNaissance) {
        Calendar dateLimite = Calendar.getInstance();
        dateLimite.add(Calendar.YEAR, -150);

        return dateDeNaissance.after(dateLimite.getTime());
    }
	
    
    public List<Person> getPeopleByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findByNomEntreprise(companyName);
        List<Person> people = jobs.stream()
                .map(Job::getPersonne)
                .collect(Collectors.toList());
        return people;
    }
    
    public List<Object> getAllPersonsDetails() {
    	
    	return personRepository.findAllByOrderByNomAscPrenomAsc().stream()
    	        .filter(Objects::nonNull) // Assurez-vous que personDTO n'est pas null
    	        .flatMap(personDTO -> {
    	            List<Job> jobs = jobRepository.findByPersonneId(personDTO.getId());
    	            
    	            if(jobs.isEmpty()) {
    	                return Stream.empty(); // Retourne un Stream vide au lieu de null
    	            }
    	            
    	            List<Job> currentJobs = jobs.stream()
    	                    .filter(job -> job.getDateFin() == null)
    	                    .collect(Collectors.toList());

    	            if (currentJobs.isEmpty()) {
    	                return Stream.empty(); // Gère aussi le cas où il n'y a pas de jobs actuels
    	            }
    	            
    	            List<JobDTO> jobsDTOCurrent = currentJobs.stream().map(job -> {
    	                JobDTO jobDTO = new JobDTO();
    	                jobDTO.setNomEntreprise(job.getNomEntreprise());
    	                jobDTO.setPoste(job.getPoste());
    	                jobDTO.setDateDebut(job.getDateDebut());
    	                jobDTO.setDateFin(job.getDateFin());
    	                jobDTO.setPersonId(job.getPersonne().getId());
    	                return jobDTO;
    	            }).collect(Collectors.toList());
    	            
    	            java.sql.Date sqlDate = (java.sql.Date) personDTO.getDateDeNaissance();
    	            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
    	            LocalDate birthDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	            
    	            int age = Period.between(birthDate, LocalDate.now()).getYears();
    	            
    	            PersonDTO result = new PersonDTO(personDTO.getNom(), personDTO.getPrenom(), age, jobsDTOCurrent);
    	            return Stream.of(result); // Retourne un Stream de PersonDTO
    	        })
    	        .collect(Collectors.toList());

    }

}
