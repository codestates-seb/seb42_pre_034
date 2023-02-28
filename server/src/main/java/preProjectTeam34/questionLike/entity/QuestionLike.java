package preProjectTeam34.questionLike.entity;

import lombok.*;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question question;

    private boolean likeState;

    public QuestionLike(Member member, Question question, boolean likeState){
        this.member = member;
        this.question = question;
        this.likeState = likeState;
    }


}
