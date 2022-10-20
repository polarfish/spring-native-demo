package com.example.nativedemo.controller;

import com.example.nativedemo.persistence.Note;
import com.example.nativedemo.persistence.NotesRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesRepository notesRepository;

    @Autowired
    public NotesController(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @GetMapping(produces = "application/json")
    ResponseEntity<List<Note>> getNotes() {
        log.info("GET /notes");
        return ResponseEntity.ok(notesRepository.findAll());
    }

    @PostMapping(produces = "application/json", consumes = {"application/json"})
    ResponseEntity<Note> postNote(@RequestBody NotePostRequest notePostRequest) {
        log.info("POST /notes (content: {})", notePostRequest.content());
        return ResponseEntity.ok(notesRepository.save(new Note(notePostRequest.content())));
    }

    @DeleteMapping
    ResponseEntity<Void> deleteAllNotes() {
        log.info("DELETE /notes");
        notesRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
