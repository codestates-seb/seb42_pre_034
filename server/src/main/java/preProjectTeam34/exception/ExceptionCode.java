package preProjectTeam34.exception;

import lombok.Getter;

public enum ExceptionCode {

    QUESTION_NOT_FOUND(404, "Question Not Found"),
    QUESTION_DELETE(409, "Question Delete"),

    ANSWER_NOT_FOUND(404, "Answer Not Found");

    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
