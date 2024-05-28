package sogong.solveconomy.apiPayload.exception.handler;


import sogong.solveconomy.apiPayload.code.BaseErrorCode;
import sogong.solveconomy.apiPayload.exception.GeneralException;

public class DictHandler extends GeneralException {

    public DictHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

