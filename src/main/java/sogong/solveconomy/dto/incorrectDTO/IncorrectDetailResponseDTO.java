package sogong.solveconomy.dto.incorrectDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncorrectDetailResponseDTO {

    private String keyword;
    private String question;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String definition;

}
