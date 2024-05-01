package sogong.solveconomy.apiPayload.exception.handler;


import sogong.solveconomy.apiPayload.code.BaseErrorCode;
import sogong.solveconomy.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {

    public UserHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

