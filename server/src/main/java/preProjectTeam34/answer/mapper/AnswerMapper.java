package preProjectTeam34.answer.mapper;


import org.mapstruct.Mapper;
import preProjectTeam34.answer.dto.AnswerPatchDto;
import preProjectTeam34.answer.dto.AnswerPostDto;
import preProjectTeam34.answer.dto.AnswerResponseDto;
import preProjectTeam34.answer.entity.Answer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    //TODO: responseDto.
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);

    List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
}
