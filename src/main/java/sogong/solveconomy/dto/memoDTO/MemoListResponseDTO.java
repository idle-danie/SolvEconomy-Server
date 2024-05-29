package sogong.solveconomy.dto.memoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MemoListResponseDTO {
    private List<MemoResponseDTO> dtos;
}
