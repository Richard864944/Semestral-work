package sk.richard.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupId;
    private Long createdBy;

    private String title;
    private String description;

    private String status; // OPEN / IN_PROGRESS / DONE

    private LocalDateTime deadline;
    private LocalDateTime createdAt = LocalDateTime.now();
}
