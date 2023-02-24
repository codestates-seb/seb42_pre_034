package preProjectTeam34.questioncomment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import preProjectTeam34.audit.Auditable;
import preProjectTeam34.question.entity.Question;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class QuestionComment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionCommentId;

    @Column(nullable = false, length = 300)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public void setQuestion(Question question){
        this.question = question;
    }


    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private QuestionCommentStatus questionCommentStatus = QuestionCommentStatus.QUESTIONCOMMENT_REGISTRATION;

    public enum QuestionCommentStatus{
        QUESTIONCOMMENT_REGISTRATION("댓글 등록 상태"),
        QUESTIONCOMMENT_DELETE("댓글 삭제 상태");

        @Getter
        private String status;

        QuestionCommentStatus(String status){
            this.status = status;
        }
    }
}
