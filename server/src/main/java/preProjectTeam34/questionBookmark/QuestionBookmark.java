package preProjectTeam34.questionBookmark;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionBookmarkId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;


}
