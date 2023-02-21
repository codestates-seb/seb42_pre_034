package preProjectTeam34.tagQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.tags.Tags;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TagsQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagsQuestionId;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "tagsId")
    private Tags tags;
}
