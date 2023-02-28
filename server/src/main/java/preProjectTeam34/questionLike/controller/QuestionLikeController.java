package preProjectTeam34.questionLike.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.question.service.QuestionService;
import preProjectTeam34.questionLike.dto.QuestionLikeDto;
import preProjectTeam34.questionLike.service.QuestionLikeService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts/{question-id}")
public class QuestionLikeController {

    private final QuestionLikeService questionLikeService;

    @PostMapping
    public ResponseEntity<Void> toggleLike(@PathVariable("question-id") Long questionId, @AuthenticationPrincipal Member member, @RequestParam(required = false, defaultValue = "true") boolean isLike){

        questionLikeService.toggleLike(questionId, member, isLike);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/upvote")
    public ResponseEntity<Boolean> isLiked(@PathVariable("question-id") Long questionId, @AuthenticationPrincipal Member member){
        boolean isLiked = questionLikeService.isLiked(questionId, member);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/downvote")
    public ResponseEntity<Boolean> isDisliked(@PathVariable("question-id") Long questionId, @AuthenticationPrincipal Member member){
        boolean isDisliked = questionLikeService.isDisliked(questionId, member);
        return ResponseEntity.ok().build();
    }




}
