package sk.richard.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.richard.server.entity.Resource;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByGroupId(Long groupId);
}
