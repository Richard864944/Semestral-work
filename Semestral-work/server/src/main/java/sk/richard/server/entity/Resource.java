package sk.richard.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupId;
    private Long uploadedBy;

    private String title;
    private String type; // FILE / LINK
    private String pathOrUrl;

    private LocalDateTime uploadedAt = LocalDateTime.now();
}
