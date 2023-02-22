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

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/answers")
@Slf4j
@Validated
public class AnswerController {
    //TODO: 필드들 추가.
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerService answerService;
    private final AnswerMapper mapper;


    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.mapper = answerMapper;
    }
//TODO: Path variable, validation 추가.
    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answerPostDto) {

        Answer answer = mapper.answerPostDtoToAnswer(answerPostDto);
        Answer createAnswer = answerService.createAnswer(answer);

        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }
    @PatchMapping("/{answer-id}/edit")
    public ResponseEntity patchAnswer(@PathVariable long answerId,
                                      @RequestBody AnswerPatchDto answerPatchDto) {
        answerPatchDto.setAnswerId(answerId);
        Answer answer =
                answerService.updateAnswer(mapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer))
                , HttpStatus.OK);
    }
    @GetMapping("/{answer-id}/delete")
    public ResponseEntity getAnswer(@PathVariable("answer-id") long answerId) {
        Answer answer = answerService.findAnswer(answerId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponseDto(answer)),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@RequestParam int page,
                                     @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.answersToAnswerResponseDtos(answers), pageAnswers),
                HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity cancelAnswer(@PathVariable("answer-id") long answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

