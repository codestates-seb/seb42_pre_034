package preProjectTeam34.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import preProjectTeam34.audit.Auditable;


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

    @Column (nullable = false, length = 5000)
    private String content;

    @Column
    private long questionId;

    @Column
    private long memberId;

    @Enumerated(EnumType.STRING)
    private AnswerStatus answerStatus = AnswerStatus.ANSWER_REGISTRATION;

    public enum AnswerStatus {
        //TODO: 필요한 status 수정, 테스트하면서 한번 더 확인.
        ANSWER_REGISTRATION("답변 등록 상태"),
        ANSWER_CLOSED("답변 채택 상태"),
        ANSWER_DELETE("답변 삭제 상태");

        @Getter
        private String status;
        AnswerStatus(String status) {
            this.status = status;
        }
    }
}
