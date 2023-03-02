package preProjectTeam34.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.questioncomment.dto.QuestionCommentDto;
import preProjectTeam34.questioncomment.entity.QuestionComment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank(message = "제목을 입력해주세요.")
        private String title;

        @NotBlank(message = "내용을 입력해주세요.")
        private String content;

        private List<QuestionComment> questionComments;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{
        private long questionId;

        private String title;

        private String content;

        private Question.QuestionStatus questionStatus;

        public void setQuestionId(long questionId){
            this.questionId = questionId;
        }
    }


    @AllArgsConstructor
    @Getter
    public static class Response{
        private Long questionId;
        private String title;
        private String content;
        private int view;
        private Question.QuestionStatus questionStatus;

        private LocalDateTime createdAt;

        private List<QuestionComment> questionComments;

        public String getQuestionStatus(){
            return questionStatus.getStatus();
        }
    }
}
