package sk.richard.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.richard.server.entity.Membership;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    List<Membership> findByUserId(Long userId);

    List<Membership> findByGroupId(Long groupId);

    Optional<Membership> findByUserIdAndGroupId(Long userId, Long groupId);
}
