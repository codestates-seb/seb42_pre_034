package preProjectTeam34.answer.dto;

import lombok.Getter;
import preProjectTeam34.answer.Answer;

@Getter
public class AnswerPatchDto {
    private long answerId;
    private Answer.AnswerStatus answerStatus;

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
