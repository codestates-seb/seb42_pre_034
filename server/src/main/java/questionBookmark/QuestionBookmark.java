package questionBookmark;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Member;


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
