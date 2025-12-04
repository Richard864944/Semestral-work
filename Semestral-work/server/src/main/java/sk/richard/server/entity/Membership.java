package sk.richard.server.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long groupId;

    private String role; // MEMBER / ADMIN

    private LocalDateTime joinedAt = LocalDateTime.now();
}
