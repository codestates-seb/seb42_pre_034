//package preProjectTeam34.questioncomment.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import preProjectTeam34.questioncomment.entity.QuestionComment;
//
//import javax.validation.constraints.NotBlank;
//
//public class QuestionCommentDto {
//
//    @Getter
//    @AllArgsConstructor
//    public static class Post{
//        @NotBlank(message = "내용을 입력해주세요.")
//        private String content;
//    }
//
//    @Getter
//    @AllArgsConstructor
//    public static class Patch{
//        private long questionCommentId;
//        private String content;
//
//        private QuestionComment.QuestionCommentStatus questionCommentStatus;
//        public void setQuestionCommentId(long questionCommentId){
//            this.questionCommentId = questionCommentId;
//        }
//    }
//
//    @Getter
//    @AllArgsConstructor
//    public static class Response{
//        private Long questionCommentId;
//        private String content;
//
//        private QuestionComment.QuestionCommentStatus questionCommentStatus;
//
//        public String getQuestionCommentStatus(){
//            return questionCommentStatus.getStatus();
//        }
//    }
//}
