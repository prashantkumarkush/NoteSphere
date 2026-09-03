package com.notesProject.NoteService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.notesProject.DTO.NoteRequestDto;
import com.notesProject.DTO.NoteResponseDTO;
import com.notesProject.Entity.Notes;
import com.notesProject.NoteRepository.NotesRepository;
import com.notesProject.exceptionHandler.ResourceNotFoundException;

@Service
public class NotesService {

	private final NotesRepository notesRepo;
	
	public NotesService(NotesRepository notesRepo) {
		this.notesRepo = notesRepo;
	}


	public NoteResponseDTO createNote( NoteRequestDto noteRequestDto) {		
		Notes note = new Notes();
		note.setTitle(noteRequestDto.getTitle());
		note.setContent(noteRequestDto.getContent());
		
		Notes save =  notesRepo.save(note);
		 return toResponseDto(save);
	}

	

	public List<NoteResponseDTO> getAllNotes() {
		
		List<Notes> notes = notesRepo.findAll();
		List<NoteResponseDTO> response = new ArrayList<>();
		
		for(Notes n : notes) {
//		 NoteResponseDTO dto = ConvertToResponseDTO(n);
		 response.add(toResponseDto(n));
		}
		return response;
	}
	
	public NoteResponseDTO getNoteById(Long id) {
		Notes response = notesRepo.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("Note id "+ id + " is Not Found"));
		return toResponseDto(response);
	}
	
	



	public List<NoteResponseDTO> searchByTitle(String title) {
		
		List<Notes> notes = notesRepo.findByTitle(title);
		List<NoteResponseDTO> response = new ArrayList<>();
		
		for(Notes note: notes) {
			response.add(toResponseDto(note));
		}
		return response;
	}
	

	public NoteResponseDTO updateNotes(Long id, NoteRequestDto noteRequestDto) {
		Notes note = notesRepo.findById(id).orElseThrow(()-> new RuntimeException("Note Doesn't exist"));
		note.setTitle(noteRequestDto.getTitle());
		note.setContent(noteRequestDto.getContent());
		
		Notes updatedNote = notesRepo.save(note); 
		return toResponseDto(updatedNote);
	}

	
	public void deleteNote(Long id) {
		Notes note = notesRepo.findById(id).orElseThrow(()-> new RuntimeException("Id doesn't match :" + id));
		notesRepo.deleteById(id);
	}

	
	
	
	private NoteResponseDTO toResponseDto(Notes note) {
		return new NoteResponseDTO(
				note.getId(),
				note.getTitle(),
				note.getContent());
	}


	





	
}
