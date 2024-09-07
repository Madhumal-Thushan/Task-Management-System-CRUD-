package com.example.task.management.system.Repository;

import com.example.task.management.system.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
