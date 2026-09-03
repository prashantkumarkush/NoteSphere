package com.notesProject.NoteRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notesProject.Entity.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
    
	List<Notes> findByTitle(String title);
}
