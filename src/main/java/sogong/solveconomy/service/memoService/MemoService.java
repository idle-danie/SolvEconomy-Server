package sogong.solveconomy.service.memoService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sogong.solveconomy.apiPayload.exception.handler.MemoHandler;
import sogong.solveconomy.apiPayload.exception.handler.UserHandler;
import sogong.solveconomy.domain.Memo;
import sogong.solveconomy.domain.User;
import sogong.solveconomy.dto.memoDTO.MemoRequestDTO;
import sogong.solveconomy.repository.MemoRepository;
import sogong.solveconomy.repository.UserRepository;

import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.MEMO_NOT_FOUND;
import static sogong.solveconomy.apiPayload.code.status.ErrorStatus.USER_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final UserRepository userRepository;

    public void write(String uid, MemoRequestDTO dto) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        Memo memo = Memo.builder()
                .user(user)
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        memoRepository.save(memo);
    }

    public void delete(String uid, Long memoId) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        Memo memo = memoRepository.findByUserAndId(user, memoId).orElseThrow(() -> new MemoHandler(MEMO_NOT_FOUND));
        memoRepository.delete(memo);
    }

    public void modify(String uid, Long memoId, MemoRequestDTO dto) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserHandler(USER_NOT_FOUND));
        Memo memo = memoRepository.findByUserAndId(user, memoId).orElseThrow(() -> new MemoHandler(MEMO_NOT_FOUND));
        memo.setTitle(dto.getTitle());
        memo.setContent(dto.getContent());
    }

}
