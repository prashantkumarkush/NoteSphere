package com.notesProject.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class NoteRequestDto {
	
	@NotBlank(message="Title  must to write ")
  private String title;
	
  @NotBlank(message ="content is must")
  private String content;

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NoteRequestDto(@NotEmpty(message = "fill the title ") String title,
			@NotEmpty(message = " write content") String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public NoteRequestDto() {
		
	}
	
  
}
