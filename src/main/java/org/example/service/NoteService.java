package org.example.service;

import jakarta.validation.Valid;
import org.example.model.Note;
import org.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(@Valid Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, @Valid Note note) {
        if (noteRepository.existsById(id)) {
            note.setId(id);
            return noteRepository.save(note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
