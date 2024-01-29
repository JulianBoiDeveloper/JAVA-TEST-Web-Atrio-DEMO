CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    date_de_naissance DATE NOT NULL
);

-- Table pour stocker les informations sur les emplois
CREATE TABLE Job (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT NOT NULL,
    nom_entreprise VARCHAR(255) NOT NULL,
    poste VARCHAR(255) NOT NULL,
    date_debut DATE NOTmybase NULL,
    date_fin DATE,
    FOREIGN KEY (person_id) REFERENCES Person(id)
);

