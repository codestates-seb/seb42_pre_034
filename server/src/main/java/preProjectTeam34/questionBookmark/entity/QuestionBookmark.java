package preProjectTeam34.questionBookmark.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class QuestionBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionBookmarkId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;


}
