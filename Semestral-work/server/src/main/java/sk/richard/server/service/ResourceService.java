package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.Resource;
import sk.richard.server.repository.ResourceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public Resource addResource(Long groupId, Long userId, String title, String type, String pathOrUrl) {
        Resource r = new Resource();
        r.setGroupId(groupId);
        r.setUploadedBy(userId);
        r.setTitle(title);
        r.setType(type);
        r.setPathOrUrl(pathOrUrl);
        return resourceRepository.save(r);
    }

    public List<Resource> getResources(Long groupId) {
        return resourceRepository.findByGroupId(groupId);
    }
}
