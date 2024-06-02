package sogong.solveconomy.service.authService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.userDTO.UserRequestDTO;
import sogong.solveconomy.repository.UserRepository;

import java.util.Optional;

import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.ALREADY_JOIN;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {

    private final UserRepository userRepository;

    public void join(UserRequestDTO dto) {
        Optional<User> foundUser = userRepository.findByUid(dto.getUid());
        if (foundUser.isPresent()) {
            throw new UserHandler(ALREADY_JOIN);
        }
        User user = User.builder()
                .uid(dto.getUid())
                .name(dto.getName())
                .build();
        userRepository.save(user);
    }
}
