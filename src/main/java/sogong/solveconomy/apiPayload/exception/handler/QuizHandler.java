package sogong.solveconomy.apiPayload.exception.handler;


import sogong.solveconomy.apiPayload.code.BaseErrorCode;
import sogong.solveconomy.apiPayload.exception.GeneralException;

public class QuizHandler extends GeneralException {

    public QuizHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

