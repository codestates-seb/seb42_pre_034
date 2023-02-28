package preProjectTeam34.questioncomment.mapper;

import org.mapstruct.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;
import preProjectTeam34.questioncomment.dto.QuestionCommentDto;
import preProjectTeam34.questioncomment.entity.QuestionComment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionCommentMapper {
    QuestionComment questionCommentPostToQuestionComment(QuestionCommentDto.Post requestBody);
    QuestionComment questionCommentPatchToQuestionComment(QuestionCommentDto.Patch requestBody);
    QuestionCommentDto.Response questionCommentToQuestionCommentResponse(QuestionComment questionComment);
    List<QuestionCommentDto.Response> questionCommentsToQuestionCommentResponse(List<QuestionComment> questionComments);
}
