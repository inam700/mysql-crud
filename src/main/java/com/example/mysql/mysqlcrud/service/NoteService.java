package com.example.mysql.mysqlcrud.service;

import com.example.mysql.mysqlcrud.model.Note;
import com.example.mysql.mysqlcrud.repo.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public int addNote(Note note){
        return noteRepository.insertNoteData(note);
    }

    public List<Note> getAllNotes(){
        return noteRepository.selectALlNotes();
    }
    public Optional<Note> getNoteById(Long id){
        return noteRepository.selectNoteById(id);
    }
    public int deleteNoteById(Long id){
        return noteRepository.deleteNoteById(id);
    }
    public int updateNoteById(Long id,Note note){
        return noteRepository.updateNoteById(id,note);
    }
}
