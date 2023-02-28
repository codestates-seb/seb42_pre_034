package preProjectTeam34.answer.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.answer.mapper.AnswerMapper;
import preProjectTeam34.answer.service.AnswerService;
import preProjectTeam34.answer.dto.AnswerPatchDto;
import preProjectTeam34.answer.dto.AnswerPostDto;
import preProjectTeam34.answer.entity.Answer;
import preProjectTeam34.dto.MultiResponseDto;
import preProjectTeam34.dto.SingleResponseDto;
import preProjectTeam34.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
@Validated
public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerService answerService;
    private final AnswerMapper mapper;


    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.mapper = answerMapper;
    }
//TODO: Post remap w/ questionService, questionId.
    @PostMapping("questions/{question-id}/answers")
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive long questionId,
                                     @Valid @RequestBody AnswerPostDto answerPostDto) {

        Answer answer = mapper.answerPostDtoToAnswer(questionId, answerPostDto);
        Answer createAnswer = answerService.createAnswer(answer);

        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }
    @PatchMapping("answers/{answer-id}/edit")
    public ResponseEntity patchAnswer(@PathVariable("question-id")@Positive long answerId,
                                      @Valid @RequestBody AnswerPatchDto answerPatchDto) {
        answerPatchDto.setAnswerId(answerId);
        Answer answer =
                answerService.updateAnswer(mapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer))
                , HttpStatus.OK);
    }
    @GetMapping("answers/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId) {
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)),
                HttpStatus.OK);
    }

    @GetMapping("answers")
    public ResponseEntity getAnswers(@RequestParam int page,
                                     @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.answersToAnswerResponseDtos(answers), pageAnswers),
                HttpStatus.OK);
    }

    @DeleteMapping("answers/{answer-id}/delete")
    public ResponseEntity cancelAnswer(@PathVariable("answer-id") @Positive long answerId) {

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

