Notes Project

A Spring Boot REST API for managing notes with MySQL database integration.

Features

Create a new note

Get all notes

Get a note by ID

Update a note

Delete a note

Request validation

Global exception handling

RESTful API

MySQL database integration



Technologies Used

Java 21

Spring Boot 4

Spring Data JPA

Hibernate

MySQL

Maven

REST API

JUnit

Eclipse IDE

Postman



Project Structure
src/main/java/com/notesProject
│

├── DTO
│   ├── ExceptionDTO
│   ├── NoteRequestDto
│   ├── NoteResponseDTO
│   └── ValidationExceptionDTO
│

├── Entity
│   └── Notes
│

├── NoteRepository
│   └── NotesRepository
│

├── NoteService
│   └── NotesService
│

├── NotesController
│   └── NotesController
│

├── exceptionHandler
│   ├── GlobalExceptionHandler
│   └── ResourceNotFoundException
│

└── NotesprojectApplication

Database:
This project uses MySQL with Spring Data JPA and Hibernate.

Create the database:

CREATE DATABASE notesdb;

Configure your database credentials in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/notesdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

Do not upload your real database password to GitHub.

How to Run

1. Clone the repository

git clone https://github.com/prashantkumarkush/notesproject.git
cd notesproject

2. Configure MySQL

Make sure MySQL is running and the notesdb database exists.

Update the database username and password in application.properties.

3. Build the project

On Windows:

mvnw.cmd clean package

Or, if Maven is installed:

mvn clean package

4. Run the application

java -jar target/notesproject-0.0.1-SNAPSHOT.jar

You can also run NotesprojectApplication.java directly from Eclipse.

Testing

The project uses JUnit and Spring Boot testing.

Run:

mvn test

Repository

GitHub: https://github.com/prashantkumarkush/notesproject

Author

Prashant Kumar
