package com.example.mysql.mysqlcrud.repo;

import com.example.mysql.mysqlcrud.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface NoteRepository {
    int insertNoteData(Note note);
    List<Note> selectALlNotes();
    Optional<Note> selectNoteById(Long id);
    int deleteNoteById(Long id);
    int updateNoteById(Long id,Note note);
}
