package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="soigneurs")
public class Soigneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prenom;
    private String nom;
    private String specialite;

    public Soigneur() {
    }

    public Soigneur(String prenom, String nom, String specialite) {
        this.prenom = prenom;
        this.nom = nom;
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Soigneur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
