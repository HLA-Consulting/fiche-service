package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data

public class enfant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    private String nom;
    private String prénom;
    private String classe;
    private Date dateNaissance;
    private Date dateInscription ;
    private byte photo;

    public enfant(long id, String nom, String prénom, String classe, Date dateNaissance, Date dateInscription, byte photo) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.classe = classe;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
        this.photo = photo;
    }

    public byte getPhoto() {

        return photo;
    }

    public String getNom() {
        return nom;
    }

    public enfant(long id, String nom, String prénom, String classe, Date dateNaissance, Date dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.classe = classe;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
    }

    public enfant() {
    }

    public String getPrénom() {
        return prénom;
    }

    public String getClasse() {
        return classe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public long getId() {

        return id;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
