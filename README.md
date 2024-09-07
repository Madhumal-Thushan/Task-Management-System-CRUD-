# Task Management System

## Description
A simple task management system built with Spring Boot and MySQL.

## Prerequisites
- JDK 11 or later
- MySQL database
- Maven (if using Maven)
- IDE (e.g., IntelliJ IDEA, Eclipse) or command line tools

## Setup and Running the Application

1. **Clone the Repository**:
   ```sh
   https://github.com/Madhumal-Thushan/Task-Management-System-CRUD-

## Configure the Database:

Update src/main/resources/application.properties with your MySQL database details:

### MySQL Database Connection Configuration
- datasource.url=jdbc:mysql://localhost:3306/task_management_db
- spring.datasource.username=root
- spring.datasource.password=root
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

### Hibernate JPA Configuration
- spring.jpa.hibernate.ddl-auto=update 
- spring.jpa.show-sql=true
- spring.jpa.generate-ddl=true
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

Check the Uploaded SQL file for Create Database and Tables

## API Endpoints

- GET /tasks: Retrieve all tasks                  
- GET /tasks/get/{id}: Retrieve a task by ID      
- POST /tasks/create: Create a new task
- PUT /tasks/update/{id}: Update an existing task
- DELETE /tasks/delete/{id}: Delete a task by ID

## Postman CURLs
````
 curl --location 'http://localhost:8080/api/tasks'
 curl --location 'http://localhost:8080/api/tasks/get/2'
 
 curl --location 'http://localhost:8080/api/tasks/create' \
--header 'Content-Type: application/json' \
--data '{
    "title": "new task7",
    "description": "new Task 7 description"
}'

curl --location --request PUT 'http://localhost:8080/api/tasks/update/7' \
--header 'Content-Type: application/json' \
--data '{
    "id": 7,
    "title": "new task7",
    "description": "new Task 7 description updated",
    "completed": false,
    "createdDate": "2024-09-07T18:41:20.938+00:00",
    "updatedDate": null
}'

curl --location --request DELETE 'http://localhost:8080/api/tasks/delete/2'
````
