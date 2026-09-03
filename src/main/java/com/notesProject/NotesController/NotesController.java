package com.notesProject.NotesController;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notesProject.DTO.NoteRequestDto;
import com.notesProject.DTO.NoteResponseDTO;
import com.notesProject.NoteService.NotesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NotesController {

	private final NotesService notesService;
	
	public NotesController(NotesService notesService) {
		this.notesService = notesService;
	}
	
	@PostMapping("/createNote")
	public ResponseEntity<NoteResponseDTO> createNote( @Valid @RequestBody NoteRequestDto noteRequestDto ){
		NoteResponseDTO note = notesService.createNote(noteRequestDto);
		return ResponseEntity
				.status(HttpStatus.CREATED).body(note);
		
	}
	
	@GetMapping
	public ResponseEntity<List<NoteResponseDTO>> getAllNotes() {

	    List<NoteResponseDTO> notes = notesService.getAllNotes();

	    return ResponseEntity.ok(notes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoteResponseDTO> getNoteById(@PathVariable Long id){
		NoteResponseDTO note = notesService.getNoteById(id);
		return ResponseEntity.ok(note);
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<NoteResponseDTO>> getNoteByTitle(@RequestParam String title){
		List<NoteResponseDTO> notes = notesService.searchByTitle(title);
		return ResponseEntity.ok(notes);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NoteResponseDTO> updateNotes(@PathVariable Long id, @Valid @RequestBody NoteRequestDto noteRequestDto){
		NoteResponseDTO UpdateNoteDto = notesService.updateNotes(id,noteRequestDto);
		
		return ResponseEntity.ok(UpdateNoteDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable Long id ){
		 notesService.deleteNote(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
}
