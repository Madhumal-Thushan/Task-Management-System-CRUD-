package com.example.task.management.system.Service;

import com.example.task.management.system.Entity.Task;
import com.example.task.management.system.Exception.TaskNotFoundException;
import com.example.task.management.system.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    /**
     * Get All tasks List
     * @return {@code List<Task>}
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * create task method.
     * @param task
     * @return task
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


    /**
     * Get a single task by passing ID
     * used lambda expression
     * @param id
     * @return {@code Task}
     */
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }

    /**
     * Update a task by Id
     * @param id
     * @return {@code Task}
     */
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found : " + id));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.getCompleted());
        task.setUpdatedDate(new Date());
        return taskRepository.save(task);
    }

    /**
     * Delete a task By Id
     * @param id
     * no return type
     */
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()->  new TaskNotFoundException("Task not found For Id : " +id ));
        taskRepository.delete(task);
    }
}
