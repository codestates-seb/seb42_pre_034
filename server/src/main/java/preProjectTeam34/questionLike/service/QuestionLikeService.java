package preProjectTeam34.questionLike.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import preProjectTeam34.member.entity.Member;
import preProjectTeam34.member.repository.MemberRepository;
import preProjectTeam34.question.entity.Question;
import preProjectTeam34.question.repository.QuestionRepository;
import preProjectTeam34.questionLike.dto.QuestionLikeDto;
import preProjectTeam34.questionLike.entity.QuestionLike;
import preProjectTeam34.questionLike.repository.QuestionLikeRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class QuestionLikeService {

    private final QuestionLikeRepository questionLikeRepository;
    public QuestionLikeService(QuestionLikeRepository questionLikeRepository){
        this.questionLikeRepository = questionLikeRepository;
    }

    @Transactional
    public void toggleLike(Long questionId, Member member, boolean likeState){
        Question question = new Question(questionId);
        Optional<QuestionLike> optionalQuestionLike = QuestionLikeRepository.findByQuestionAndMember(question, member);
        QuestionLike questionLike;

        if(optionalQuestionLike.isPresent()){
            questionLike = optionalQuestionLike.get();
            if(questionLike.isLikeState() == likeState){
                questionLikeRepository.delete(questionLike);
            }
            else{
                questionLike.setLikeState(likeState);
                questionLikeRepository.save(questionLike);
            }
        }
        else{
            questionLike = new QuestionLike(member, question, likeState);
            questionLikeRepository.save(questionLike);
        }
    }

    public boolean isLiked(Long questionId, Member member){
        Question question = new Question(questionId);
        Optional<QuestionLike> optionalQuestionLike = QuestionLikeRepository.findByQuestionAndMember(question, member);
        return optionalQuestionLike.isPresent() && optionalQuestionLike.get().isLikeState();
    }

    public boolean isDisliked(Long questionId, Member member){
        Question question = new Question(questionId);
        Optional<QuestionLike> optionalQuestionLike = QuestionLikeRepository.findByQuestionAndMember(question, member);
        return optionalQuestionLike.isPresent() && optionalQuestionLike.get().isLikeState();
    }

}
