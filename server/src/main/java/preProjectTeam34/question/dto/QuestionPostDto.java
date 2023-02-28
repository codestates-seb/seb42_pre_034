package preProjectTeam34.question.dto;

import lombok.Getter;
import preProjectTeam34.questioncomment.entity.QuestionComment;

import javax.validation.constraints.Positive;
import java.util.List;

@Getter
public class QuestionPostDto {
    @Positive
    private long questionCommentId;

    private List<QuestionComment> questionComments;
}
