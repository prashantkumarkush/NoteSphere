package com.notesProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="NotesTable")
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
	
   private String title;
   private String content;
   
   public Notes() {
		
	}
   
   public long getId() {
	return id;
   }
   public void setId(long id) {
	this.id = id;
   }
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
   public Notes(String title, String content) {
	super();
	
	this.title = title;
	this.content = content;
   }
   
   
}
