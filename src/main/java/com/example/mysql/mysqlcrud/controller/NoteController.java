package com.example.mysql.mysqlcrud.controller;

import com.example.mysql.mysqlcrud.model.Note;
import com.example.mysql.mysqlcrud.service.NoteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public void addNote(@Valid @NotNull @RequestBody Note note){
        noteService.addNote(note);
    }
    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getAllNotes();
    }
    @GetMapping("{id}")
    public Optional<Note> getNoteById(@PathVariable("id") Long id){
        return noteService.getNoteById(id);
    }
    @DeleteMapping("{id}")
    public int deleteNote(@PathVariable("id") Long id){
        return noteService.deleteNoteById(id);
    }
    @PutMapping("{id}")
    public int updateNote(@PathVariable("id") Long id,Note note){
        return noteService.updateNoteById(id,note);
    }
}
