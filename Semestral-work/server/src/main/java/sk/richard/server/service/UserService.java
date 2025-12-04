package sk.richard.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.richard.server.entity.User;
import sk.richard.server.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
