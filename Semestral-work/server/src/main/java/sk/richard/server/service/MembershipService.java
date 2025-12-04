package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.Membership;
import sk.richard.server.repository.MembershipRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public Membership joinGroup(Long userId, Long groupId, String role) {

        if (membershipRepository.findByUserIdAndGroupId(userId, groupId).isPresent()) {
            throw new RuntimeException("User already in group");
        }

        Membership m = new Membership();
        m.setUserId(userId);
        m.setGroupId(groupId);
        m.setRole(role);

        return membershipRepository.save(m);
    }

    public List<Membership> getGroupMembers(Long groupId) {
        return membershipRepository.findByGroupId(groupId);
    }

    public boolean isMember(Long userId, Long groupId) {
        return membershipRepository.findByUserIdAndGroupId(userId, groupId).isPresent();
    }

    public boolean isAdmin(Long userId, Long groupId) {
        return membershipRepository.findByUserIdAndGroupId(userId, groupId)
                .map(m -> m.getRole().equals("ADMIN"))
                .orElse(false);
    }
}
