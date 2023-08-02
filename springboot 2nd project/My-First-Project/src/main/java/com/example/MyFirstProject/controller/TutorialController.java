package com.example.MyFirstProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MyFirstProject.model.Tutorial;
import com.example.MyFirstProject.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    // GET all tutorials
    @GetMapping("/show_all")
    public List<Tutorial> getAllTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    // GET tutorial by ID
    @GetMapping("/show/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);

        if (tutorial.isPresent()) {
            return ResponseEntity.ok(tutorial.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST create a new tutorial
    @PostMapping("/create")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial newTutorial) {
        Tutorial savedTutorial = tutorialRepository.save(newTutorial);
        return ResponseEntity.ok(savedTutorial);
    }

    // PUT update an existing tutorial
    @PutMapping("/update/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id, @RequestBody Tutorial updatedTutorial) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);

        if (tutorial.isPresent()) {
            Tutorial existingTutorial = tutorial.get();
            existingTutorial.setTitle(updatedTutorial.getTitle());
            existingTutorial.setDescription(updatedTutorial.getDescription());
            // Update other properties as needed

            Tutorial savedTutorial = tutorialRepository.save(existingTutorial);
            return ResponseEntity.ok(savedTutorial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a tutorial by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable Long id) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(id);

        if (tutorial.isPresent()) {
            tutorialRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
