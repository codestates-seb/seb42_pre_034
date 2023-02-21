package preProjectTeam34.answer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
//TODO: Auditable, enum status 확인.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column
    private String content;

    @Column
    private long questionId;

    @Column
    private long memberId;

    @Enumerated(EnumType.STRING)
    private AnswerStatus answerStatus = AnswerStatus.ANSWER_REQUEST;

    public enum AnswerStatus {
        //TODO: Request 상태 수정.
        ANSWER_REQUEST(1, "질문 요청"),
        ANSWER_CANCEL(2, "질문 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        AnswerStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}
