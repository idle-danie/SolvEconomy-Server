package sogong.solveconomy.service.memoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.converter.MemoConverter;
import sogong.solveconomy.domain.Memo;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.memoDTO.MemoListResponseDTO;
import sogong.solveconomy.dto.memoDTO.MemoResponseDTO;
import sogong.solveconomy.repository.MemoRepository;
import sogong.solveconomy.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.USER_NOT_FOUND;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemoQueryService {

    private final UserRepository userRepository;

    public List<Memo> getMemos(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        return user.getMemoList();
    }


}
