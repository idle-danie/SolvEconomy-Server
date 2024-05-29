package sogong.solveconomy.converter;

import sogong.solveconomy.domain.Memo;
import sogong.solveconomy.dto.memoDTO.MemoResponseDTO;

public class MemoConverter {

    public static MemoResponseDTO toMemoDTO(Memo memo) {
        return MemoResponseDTO.builder()
                .id(memo.getId())
                .title(memo.getTitle())
                .content(memo.getContent())
                .build();
    }
}
