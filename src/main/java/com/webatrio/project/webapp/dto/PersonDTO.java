package com.webatrio.project.webapp.dto;

import java.util.List;

import com.webatrio.project.webapp.entity.Job;

public class PersonDTO {
	
	
	private String nom;
    private String prenom;
    private int age;
    private List<JobDTO> currentJobs;

    


	public PersonDTO(String nom, String prenom, int age, List<JobDTO> currentJobs) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.currentJobs = currentJobs;
	}
	public List<JobDTO> getCurrentJobs() {
		return currentJobs;
	}
	public void setCurrentJobs(List<JobDTO> currentJobs) {
		this.currentJobs = currentJobs;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
    
    
    
}
