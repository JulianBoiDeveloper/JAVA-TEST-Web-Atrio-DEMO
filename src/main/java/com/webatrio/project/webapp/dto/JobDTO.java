package com.webatrio.project.webapp.dto;

import java.util.Date;

public class JobDTO {
	
    private Long personId;
    private String nomEntreprise;
    private String poste;
    private Date dateDebut;
    private Date dateFin;
    


    // Getters et setters

	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
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
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
    
}