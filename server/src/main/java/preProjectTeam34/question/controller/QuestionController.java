package preProjectTeam34.question.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.dto.SingleResponseDto;
import preProjectTeam34.question.dto.QuestionDto;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.question.mapper.QuestionMapper;
import preProjectTeam34.question.service.QuestionService;
import preProjectTeam34.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/questions")
@Validated
@Slf4j
public class QuestionController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.mapper = questionMapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody){
        Question question = mapper.questionPostToQuestion(requestBody);
        Question createQuestion = questionService.createQuestion(question);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, createQuestion.getQuestionId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{question-id}/edit")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive long questionId,
                                       @Valid @RequestBody QuestionDto.Patch requestBody){
        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchToQuestion(requestBody));

        return new ResponseEntity(
            new SingleResponseDto<>(mapper.questionToQuestionResponse(question)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{question-id}/{title}")
    public ResponseEntity getQuestion(
            @PathVariable("question-id") @Positive long questionId,
            @PathVariable("title") String title
    ){
        Question question = questionService.findQuestion(questionId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionResponse(question)),HttpStatus.OK
        );

    }
}
