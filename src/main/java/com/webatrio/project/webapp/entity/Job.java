package com.webatrio.project.webapp.entity;

import java.util.Date;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEntreprise;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personne;

	private Date dateDebut;

	private Date dateFin;


    // Getters et setters
	public Long getId() {
		return id;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Person getPersonne() {
		return personne;
	}

	public void setPersonne(Person personne) {
		this.personne = personne;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
		
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", nomEntreprise=" + nomEntreprise + ", poste=" + poste + ", personne=" + personne
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	


    
}