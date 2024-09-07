This is Task Managament CRUD APIs 


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
   git clone https://github.com/your-username/task-management-system.git

## Configure the Database:

Update src/main/resources/application.properties with your MySQL database details:

- spring.datasource.url=jdbc:mysql://localhost:3306/task_management_db
- spring.datasource.username=root
- spring.datasource.password=password
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

Check the Uploaded SQL file for Create Database and Tables

## API Endpoints and Postman CURLs

- GET /tasks: Retrieve all tasks                  
- GET /tasks/get/{id}: Retrieve a task by ID      
- POST /tasks/create: Create a new task
- PUT /tasks/update/{id}: Update an existing task
- DELETE /tasks/delete/{id}: Delete a task by ID


```sh
 Get Allcurl --location 'http://localhost:8080/api/tasks'
 Get by Iurl --location 'http://localhost:8080/api/tasks/get/2'
 curl --location 'http://localhost:8080/api/tasks/create' \
--header 'Content-Type: application/json' \
--data '{
    "title": "new task7",
    "description": "new Task 7 description"
}'
