package preProjectTeam34.questionLike.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import preProjectTeam34.questionLike.entity.QuestionLike;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class QuestionLikeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionLikeId;
    private Long memberId;
    private Long questionId;
    private boolean likeState;

    public QuestionLikeDto(Long memberId, Long questionId, boolean likeState){
        this.memberId = memberId;
        this.questionId = questionId;
        this.likeState = likeState;
    }

}
