package preProjectTeam34.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class AnswerPostDto {
    //TODO: Pattern 등 validation 조건 채우기, Question과 조건 맞추기
//    @NotBlank
//    private Long answerId;

    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 10, message = "내용을 10자 이상 입력해주세요.")
    private String content;

}