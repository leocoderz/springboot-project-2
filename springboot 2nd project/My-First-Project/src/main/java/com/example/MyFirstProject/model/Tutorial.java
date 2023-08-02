package com.example.MyFirstProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyFirstProject")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Tutorial() {
        // Empty constructor required for JPA
    }

    public Tutorial(String firstname, String lastname, String password, String title, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.title = title;
        this.description = description;
    }

    // Getters and setters for all properties

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
                + ", title=" + title + ", description=" + description + "]";
    }
}
