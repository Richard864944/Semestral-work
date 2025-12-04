package sk.richard.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.richard.server.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findByCreatedBy(Long createdBy);
}
