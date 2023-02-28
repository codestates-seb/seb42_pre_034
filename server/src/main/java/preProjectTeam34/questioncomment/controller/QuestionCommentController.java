package preProjectTeam34.questioncomment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.dto.SingleResponseDto;
import preProjectTeam34.questioncomment.dto.QuestionCommentDto;
import preProjectTeam34.questioncomment.entity.QuestionComment;
import preProjectTeam34.questioncomment.mapper.QuestionCommentMapper;
import preProjectTeam34.questioncomment.service.QuestionCommentService;
import preProjectTeam34.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/comments")
@Validated
@Slf4j
public class QuestionCommentController {
    private final static String QUESTIONCOMMENT_DEFAULT_URL = "/comments";
    private final QuestionCommentService questionCommentService;
    private final QuestionCommentMapper mapper;

    public QuestionCommentController(QuestionCommentService questionCommentService, QuestionCommentMapper mapper) {
        this.questionCommentService = questionCommentService;
        this.mapper = mapper;
    }

   @PostMapping("/post/{question-id}/comments/add")
   public ResponseEntity postQuestionComment(
           @PathVariable("question-id") @Positive long questionId,
           @Valid @RequestBody QuestionCommentDto.Post requestBody){
       QuestionComment questionComment = mapper.questionCommentPostToQuestionComment(requestBody);

       QuestionComment createQuestionComment = questionCommentService.createQuestionComment(questionComment);


       URI location = UriCreator.createUri(QUESTIONCOMMENT_DEFAULT_URL, createQuestionComment.getQuestionCommentId());

       return ResponseEntity.created(location).build();
   }

   @PatchMapping("/{comment-id}/edit")
    public ResponseEntity patchQuestionComment(@PathVariable("comment-id") @Positive long questionCommentId,
   @Valid @RequestBody QuestionCommentDto.Patch requestBody){

        requestBody.setQuestionCommentId(questionCommentId);
        QuestionComment questionComment = questionCommentService.updateQuestionComment(mapper.questionCommentPatchToQuestionComment(requestBody));

        return new ResponseEntity(
                new SingleResponseDto<>(mapper.questionCommentToQuestionCommentResponse(questionComment)),
                HttpStatus.OK
        );
   }

   @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteQuestionComment(@PathVariable("comment-id") @Positive long questionCommentId){
        questionCommentService.deleteQuestionComment(questionCommentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}
