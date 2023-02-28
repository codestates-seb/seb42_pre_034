package preProjectTeam34.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import preProjectTeam34.question.dto.QuestionDto;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.questioncomment.dto.QuestionCommentDto;
import preProjectTeam34.questioncomment.entity.QuestionComment;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post requestBody);
    Question questionPatchToQuestion(QuestionDto.Patch requestBody);
    QuestionDto.Response questionToQuestionResponse(Question question);
    List<QuestionDto.Response> questionsToQuestionResponse(List<Question> questions);

    default List<QuestionCommentDto.Response> questionCommentToQuestionCommentResponse
            (List<QuestionComment> questionComments){

        return questionComments
                .stream()
                .map(questionComment -> QuestionCommentDto.Response
                                .builder()
                                .questionCommentId(questionComment.getQuestionCommentId())
                                .content(questionComment.getContent())
                                .questionCommentStatus(questionComment.getQuestionCommentStatus())
                                .build()
                        ).collect(Collectors.toList());
    }
}
