package preProjectTeam34.questionBookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import preProjectTeam34.questionBookmark.entity.QuestionBookmark;
import preProjectTeam34.questionBookmark.service.QuestionBookMarkService;

import java.util.List;

@RestController
@RequestMapping("/users/saves")
public class QuestionBookmarkController {

    private QuestionBookMarkService questionBookMarkService;

    @PostMapping
    public ResponseEntity<Void> createBookmark(@PathVariable Long memberId, @PathVariable Long questionId){
        questionBookMarkService.createBookmark(memberId, questionId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id){
        questionBookMarkService.deleteBookmark(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId}/all")
    public ResponseEntity<Page<QuestionBookmark>> getBookmarksByMemberId(@PathVariable("userId") Long memberId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        Page<QuestionBookmark> questionBookmarks = questionBookMarkService.getQuestionBookmarkByMemberId(memberId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(questionBookmarks);
    }


}
