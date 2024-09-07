package com.example.task.management.system.Service;

import com.example.task.management.system.Entity.Task;
import com.example.task.management.system.Repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest

public class TaskServiceTest {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        Task createdTask = taskService.createTask(task);
        assertEquals("Test Task", createdTask.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        Task foundTask = taskService.getTaskById(1L);
        assertNotNull(foundTask);
        assertEquals(1L, foundTask.getId());
    }

    @Test
    void testUpdateTask() {
        Task existingTask = new Task();
        existingTask.setId(1L);
        existingTask.setTitle("Old Title");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(existingTask));

        Task updatedTask = new Task();
        updatedTask.setTitle("New Title");

        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(1L, updatedTask);
        assertEquals("New Title", result.getTitle());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task();
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).delete(task);
    }

}
