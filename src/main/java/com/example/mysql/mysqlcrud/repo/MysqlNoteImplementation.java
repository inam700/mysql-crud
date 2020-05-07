package com.example.mysql.mysqlcrud.repo;

import com.example.mysql.mysqlcrud.model.Note;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MysqlNoteImplementation implements NoteRepository {
    private final JdbcTemplate jdbcTemplate;

    public MysqlNoteImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertNoteData(Note note) {
        final String sql="INSERT INTO notes(title,content) VALUES(?,?)";
        return jdbcTemplate.update(sql,new Object[]{note.getTitle(),note.getContent()});
    }

    @Override
    public List<Note> selectALlNotes() {
        final String sql="SELECT * FROM notes";

        return jdbcTemplate.query(sql, (resultSet,i) -> {
            Long id=resultSet.getLong("Id");
            String title=resultSet.getString("title");
            String content=resultSet.getString("content");
            return new Note(id,title,content);
        });
    }

    @Override
    public Optional<Note> selectNoteById(Long id) {
        final String sql="SELECT * FROM notes WHERE id = ?";
        Note note=jdbcTemplate.queryForObject(sql,new Object []{id},(resultSet, i) -> {
            Long noteId=resultSet.getLong("Id");
            String title=resultSet.getString("title");
            String content=resultSet.getString("content");
            return new Note(noteId,title,content);
        });
        return Optional.ofNullable(note);
    }

    @Override
    public int deleteNoteById(Long id) {
        final String sql="DELETE FROM notes WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateNoteById(Long id, Note note) {
        final String sql="UPDATE note SET title:title, content:content WHERE id = ? ";
        return jdbcTemplate.update(sql);
    }
}
