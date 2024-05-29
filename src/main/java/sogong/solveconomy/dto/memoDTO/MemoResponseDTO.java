package sogong.solveconomy.dto.memoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MemoResponseDTO {
    private Long id;
    private String title;
    private String content;
}
