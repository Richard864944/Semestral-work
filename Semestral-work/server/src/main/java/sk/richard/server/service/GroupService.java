package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.Group;
import sk.richard.server.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group createGroup(Long userId, String name, String description) {
        Group g = new Group();
        g.setCreatedBy(userId);
        g.setName(name);
        g.setDescription(description);
        return groupRepository.save(g);
    }

    public List<Group> getGroupsCreatedBy(Long userId) {
        return groupRepository.findByCreatedBy(userId);
    }

    public Group getGroup(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }
}
