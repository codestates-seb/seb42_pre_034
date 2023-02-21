package tagQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tags.Tags;

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
