package sogong.solveconomy.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sogong.solveconomy.apiPayload.code.BaseErrorCode;
import sogong.solveconomy.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
