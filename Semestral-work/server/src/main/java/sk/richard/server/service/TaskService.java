package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.Task;
import sk.richard.server.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Long groupId, Long userId, String title, String desc, LocalDateTime deadline) {
        Task t = new Task();
        t.setGroupId(groupId);
        t.setCreatedBy(userId);
        t.setTitle(title);
        t.setDescription(desc);
        t.setDeadline(deadline);
        t.setStatus("OPEN");

        return taskRepository.save(t);
    }

    public List<Task> getTasks(Long groupId) {
        return taskRepository.findByGroupId(groupId);
    }

    public Task updateStatus(Long taskId, String status) {
        Task t = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        t.setStatus(status);
        return taskRepository.save(t);
    }
}
