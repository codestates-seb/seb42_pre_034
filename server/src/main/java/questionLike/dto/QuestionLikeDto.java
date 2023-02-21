package questionLike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionLikeDto {

    private Long memberId;
    private Long questionId;

    public QuestionLikeDto(Long memberId, Long questionId){
        this.memberId = memberId;
        this.questionId = questionId;
    }
}
