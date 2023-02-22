package preProjectTeam34.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import preProjectTeam34.answer.entity.Answer;

@Getter
@AllArgsConstructor
public class AnswerPatchDto {
    private long answerId;
    private String content;
    private Answer.AnswerStatus answerStatus;

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
