package preProjectTeam34.answer.mapper;


import preProjectTeam34.answer.dto.AnswerPatchDto;
import preProjectTeam34.answer.dto.AnswerPostDto;
import preProjectTeam34.answer.dto.AnswerResponseDto;
import preProjectTeam34.answer.entity.Answer;

import java.util.List;

public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    //TODO: responseDto.
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);

    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
}
