package preProjectTeam34.questioncomment.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class QuestionCommentPostDto {
    @Positive
    private Long questionId;
}
