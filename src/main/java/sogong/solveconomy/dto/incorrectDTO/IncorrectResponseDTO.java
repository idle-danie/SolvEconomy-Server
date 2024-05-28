package sogong.solveconomy.dto.incorrectDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncorrectResponseDTO {
    private List<String> incorrectList;
}
