package preProjectTeam34.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import preProjectTeam34.question.dto.QuestionDto;
import preProjectTeam34.question.entity.Question;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post requestBody);
    Question questionPatchToQuestion(QuestionDto.Patch requestBody);
    QuestionDto.Response questionToQuestionResponse(Question question);
    List<QuestionDto.Response> questionsToQuestionResponse(List<Question> questions);
}
