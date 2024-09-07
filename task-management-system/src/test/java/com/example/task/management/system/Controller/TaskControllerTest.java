package com.example.task.management.system.Controller;

import com.example.task.management.system.Entity.Task;
import com.example.task.management.system.Service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;


public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        Task task = new Task();
        when(taskService.getAllTasks()).thenReturn(Collections.singletonList(task));
        assertEquals(Collections.singletonList(task), taskController.getAllTasks());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        when(taskService.getTaskById(1L)).thenReturn(task);
        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(task, response.getBody());
    }

    @Test
    void testCreateTask() {
        Task task = new Task();
        when(taskService.createTask(task)).thenReturn(task);
        ResponseEntity<Task> response = taskController.createTask(task);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(task, response.getBody());
    }

    @Test
    void testUpdateTask() {
        Task task = new Task();
        when(taskService.updateTask(1L, task)).thenReturn(task);
        ResponseEntity<Task> response = taskController.updateTask(1L, task);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(task, response.getBody());
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskService).deleteTask(1L);
        ResponseEntity<String> response = taskController.deleteTask(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Task deleted successfully!.", response.getBody());
    }
}
