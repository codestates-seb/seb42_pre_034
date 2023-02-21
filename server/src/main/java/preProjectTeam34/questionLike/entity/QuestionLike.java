package preProjectTeam34.questionLike.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class QuestionLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionLikeId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    @Builder
    public QuestionLike(Member member, Question question){
        this.member = member;
        this.question = question;
    }
}
