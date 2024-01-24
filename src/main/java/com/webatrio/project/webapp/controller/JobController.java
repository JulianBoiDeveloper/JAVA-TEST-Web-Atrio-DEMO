package com.webatrio.project.webapp.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webatrio.project.webapp.dto.JobDTO;
import com.webatrio.project.webapp.entity.Job;
import com.webatrio.project.webapp.entity.Person;
import com.webatrio.project.webapp.service.JobService;
import com.webatrio.project.webapp.service.PersonService;

@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired 
    private JobService jobService;
	
	@Autowired 
    private PersonService personService;
	
    
	
	@PostMapping	
    public ResponseEntity<?> addJob(@RequestBody JobDTO jobDTO) {
    	
        try {
            Job job = jobService.addJob(jobDTO);
            return ResponseEntity.ok(job);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    
    }
    
    @RequestMapping(value = "/by-person-and-date-range", method = RequestMethod.GET)
    public List<Job> getJobsByPersonAndDateRange(
        @RequestParam Long personneId,
        @RequestParam Date startDate,
        @RequestParam Date endDate) {
        Person personne = personService.getPersonById(personneId);
        if (personne == null) {
            return null;
        }
        System.out.println(personne.toString());
        List<Job> jobs = jobService.getJobsByPersonAndDateRange(personne, startDate, endDate);
        //System.out.println(jobs.toString());
        return jobs;
    }

}
