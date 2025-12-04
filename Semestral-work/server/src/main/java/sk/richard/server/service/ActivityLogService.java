package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.ActivityLog;
import sk.richard.server.repository.ActivityLogRepository;

@Service
@RequiredArgsConstructor
public class ActivityLogService {

    private final ActivityLogRepository repo;

    public void log(Long userId, String action, String details) {
        ActivityLog log = new ActivityLog();
        log.setUserId(userId);
        log.setAction(action);
        log.setDetails(details);
        repo.save(log);
    }
}
