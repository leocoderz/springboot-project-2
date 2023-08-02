package com.example.MyFirstProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.MyFirstProject.model.Tutorial;

public interface TutorialRepository extends CrudRepository<Tutorial,Long> {

    
}
