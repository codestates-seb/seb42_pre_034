package preProjectTeam34.questionLike.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.questionLike.dto.QuestionLikeDto;
import preProjectTeam34.questionLike.service.QuestionLikeService;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/{question-id}/vote")
public class QuestionLikeController {

    private final QuestionLikeService questionLikeService;

    @PostMapping("/upvote")
    public ResponseEntity<?> insertLike(@RequestBody @Valid QuestionLikeDto questionLikeDto, @PathVariable("question-id") long questionId) throws Exception{

        questionLikeService.insertLike(questionLikeDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/upvote")
    public ResponseEntity<?> deleteLike(@RequestBody @Valid QuestionLikeDto questionLikeDto, @PathVariable("question-id") long questionId) throws Exception{

        questionLikeService.deleteLike(questionLikeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
