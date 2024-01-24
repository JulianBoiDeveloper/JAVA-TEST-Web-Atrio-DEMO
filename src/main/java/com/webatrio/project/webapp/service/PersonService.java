package com.webatrio.project.webapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
