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

@Service
@RequiredArgsConstructor
public class QuestionLikeService {

    private final QuestionLikeRepository questionLikeRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public void insertLike(QuestionLikeDto questionLikeDto) throws Exception{

        Member member = memberRepository.findById(questionLikeDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("--"));

        Question question = questionRepository.findById(questionLikeDto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("--"));
        //RuntimeException 부분 임시... 따로 예외처리 필요

        if(questionLikeRepository.findByMemberAndQuestion(member, question).isPresent()){
            //좋아요 이미 되있을 경우 에외처리
        }

        QuestionLike questionLike = QuestionLike.builder()
                .question(question)
                .member(member)
                .build();

        questionLikeRepository.save(questionLike);
        // 좋아요 추가 questionRepository.

    }

    @Transactional
    public void deleteLike(QuestionLikeDto questionLikeDto) throws Exception{

        Member member = memberRepository.findById(questionLikeDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("--"));

        Question question = questionRepository.findById(questionLikeDto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("--"));

        QuestionLike questionLike = questionLikeRepository.findByMemberAndQuestion(member, question)
                .orElseThrow(() -> new RuntimeException("--"));
        //RuntimeException 부분 임시... 따로 예외처리 필요

        questionLikeRepository.delete(questionLike);
        //좋아요 내리기 questionRepository.
    }
}
