package sk.richard.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.richard.server.entity.ActivityLog;

import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    List<ActivityLog> findByUserId(Long userId);
}
