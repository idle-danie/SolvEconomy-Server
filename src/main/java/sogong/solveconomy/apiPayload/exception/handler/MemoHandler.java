package sogong.solveconomy.apiPayload.exception.handler;


import sogong.solveconomy.apiPayload.code.BaseErrorCode;
import sogong.solveconomy.apiPayload.exception.GeneralException;

public class MemoHandler extends GeneralException {

    public MemoHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

