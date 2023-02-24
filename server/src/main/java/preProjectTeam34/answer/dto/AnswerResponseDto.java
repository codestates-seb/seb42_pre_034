package preProjectTeam34.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import preProjectTeam34.answer.entity.Answer;

@Getter
@AllArgsConstructor
public class AnswerResponseDto {

        private long answerId;
        private long questionId;
        private String content;

        private Answer.AnswerStatus answerStatus;

        public String getAnswerStatus() {
            return answerStatus.getStatus();
        }
}
