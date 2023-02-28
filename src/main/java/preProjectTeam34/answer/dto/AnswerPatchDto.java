package preProjectTeam34.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import preProjectTeam34.answer.entity.Answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class AnswerPatchDto {
    private long answerId;

    @NotBlank
    @Size(min = 10, message = "내용을 10자 이상 입력해주세요.")
    private String content;

    private Answer.AnswerStatus answerStatus;

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
