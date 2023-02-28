package preProjectTeam34.question.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import preProjectTeam34.audit.Auditable;
import preProjectTeam34.questioncomment.entity.QuestionComment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private int view;

    public Question(String title, String content){
        this.title = title;
        this.content = content;
    }
    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<QuestionComment> questionComments = new ArrayList<>();
//    private String searchType;

//    private String keyWord;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_REGISTRATION;

//    private Member member;


    public enum QuestionStatus{
        QUESTION_REGISTRATION("질문 등록 상태"),
        QUESTION_ANSWERED("답변 완료 상태"),
        QUESTION_DELETE("질문 삭제 상태");

        @Getter
        private String status;

        QuestionStatus(String status){
            this.status = status;
        }
    }
}
