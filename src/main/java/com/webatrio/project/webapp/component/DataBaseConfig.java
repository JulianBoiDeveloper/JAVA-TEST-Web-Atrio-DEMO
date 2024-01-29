package com.webatrio.project.webapp.component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {

    @Value("${person.years.max}")
    private String maxYearsPerson;

	public String getMaxYearsPerson() {
		return maxYearsPerson;
	}

	public void setMaxYearsPerson(String maxYearsPerson) {
		this.maxYearsPerson = maxYearsPerson;
	}

}