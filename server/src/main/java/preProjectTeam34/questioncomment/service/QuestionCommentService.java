package preProjectTeam34.questioncomment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import preProjectTeam34.exception.BusinessLogicException;
import preProjectTeam34.exception.ExceptionCode;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.question.repository.QuestionRepository;
import preProjectTeam34.question.service.QuestionService;
import preProjectTeam34.questioncomment.entity.QuestionComment;
import preProjectTeam34.questioncomment.repository.QuestionCommentRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class QuestionCommentService {
    private final QuestionCommentRepository questionCommentRepository;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    public QuestionCommentService(QuestionCommentRepository questionCommentRepository, QuestionService questionService, QuestionRepository questionRepository) {
        this.questionCommentRepository = questionCommentRepository;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    public QuestionComment createQuestionComment(QuestionComment questionComment){

        QuestionComment saveQuestionComment = questionCommentRepository.save(questionComment);
//        Question question = questionService.findQuestion(questionComment.getQuestion().getQuestionId());
//        System.out.println(question);
//        List<QuestionComment> questionCommentList = question.getQuestionComments();
//        questionCommentList.add(questionComment);
//        questionRepository.save(question);
        return saveQuestionComment;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public QuestionComment updateQuestionComment(QuestionComment questionComment){
        QuestionComment findQuestionComment = findVerifiedQuestionComment(questionComment.getQuestionCommentId());

        Optional.ofNullable(questionComment.getContent())
                .ifPresent(content -> findQuestionComment.setContent(content));

        return questionCommentRepository.save(findQuestionComment);
    }

    @Transactional(readOnly = true)
    public QuestionComment findQuestionComment(long questionCommentId){
        return findVerifiedQuestionComment(questionCommentId);
    }

    @Transactional(readOnly = true)
    public Page<QuestionComment> findQuestionComments(int page, int size){
        return questionCommentRepository.findAll(
                PageRequest.of(page, size, Sort.by("questionCommentId").descending())
        );
    }

    public void deleteQuestionComment(long questionCommentId){
        QuestionComment findQuestionComment = findVerifiedQuestionComment(questionCommentId);

        questionCommentRepository.delete(findQuestionComment);
    }

    public QuestionComment findVerifiedQuestionComment(long questionCommentId){
        Optional<QuestionComment> optionalQuestionComment = questionCommentRepository.findById(questionCommentId);

        QuestionComment findQuestionComment =
                optionalQuestionComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return findQuestionComment;
    }
}
