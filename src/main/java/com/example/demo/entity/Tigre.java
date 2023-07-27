package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tigres")
public class Tigre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private Integer age;

    @ManyToOne
    private Zoo zoo;

    @ManyToMany
    private List<Soigneur> soigneurs;
    // je laisse à NULL pour que le PATCH fonctionne correctement
    // = new ArrayList<>();

    public Tigre() {
    }

    public Tigre(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public List<Soigneur> getSoigneurs() {
        return soigneurs;
    }

    public void setSoigneurs(List<Soigneur> soigneurs) {
        this.soigneurs = soigneurs;
    }

    @Override
    public String toString() {
        return "Tigre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", zoo=" + zoo +
                ", soigneurs=" + soigneurs +
                '}';
    }

    public void addSoigneur(Soigneur soigneur){
        if(soigneurs == null) {
            soigneurs = new ArrayList<>();
        }
        this.soigneurs.add(soigneur);
    }

    public void updateNotNull(Tigre tigrePatch) {
        if(tigrePatch.getAge() != null ) {
            this.setAge(tigrePatch.getAge());
        }
        if(tigrePatch.getNom() != null ) {
            this.setNom(tigrePatch.getNom());
        }
        if(tigrePatch.getZoo() != null ) {
            this.setZoo(tigrePatch.getZoo());
        }
        if(tigrePatch.getSoigneurs() != null ) {
            this.setSoigneurs(tigrePatch.getSoigneurs());
        }
    }
}
