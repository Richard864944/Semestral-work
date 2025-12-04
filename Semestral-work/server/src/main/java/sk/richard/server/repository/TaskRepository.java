package sk.richard.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.richard.server.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByGroupId(Long groupId);
}
