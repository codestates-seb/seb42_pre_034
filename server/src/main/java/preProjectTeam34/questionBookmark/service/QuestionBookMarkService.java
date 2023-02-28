package preProjectTeam34.questionBookmark.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.questionBookmark.entity.QuestionBookmark;
import preProjectTeam34.questionBookmark.repository.QuestionBookmarkRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionBookMarkService {

    private QuestionBookmarkRepository questionBookmarkRepository;

    public void createBookmark(Long memberId, Long questionId){
        Optional<QuestionBookmark> bookmark = questionBookmarkRepository.findByMemberIdAndQuestionId(memberId, questionId);
        if(bookmark.isPresent()) return;

        Member member = new Member();
        member.setMemberId(memberId);

        Question question = new Question();
        question.setQuestionId(questionId);

        QuestionBookmark newQuestionBookmark = new QuestionBookmark();
        newQuestionBookmark.setMember(member);
        newQuestionBookmark.setQuestion(question);

        questionBookmarkRepository.save(newQuestionBookmark);

    }

    public void deleteBookmark(Long id){
        questionBookmarkRepository.deleteById(id);
    }

    public Page<QuestionBookmark> getQuestionBookmarkByMemberId(Long memberId, Pageable pageable){
        return questionBookmarkRepository.findByMemberId(memberId, pageable);
    }



}
