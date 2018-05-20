package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
