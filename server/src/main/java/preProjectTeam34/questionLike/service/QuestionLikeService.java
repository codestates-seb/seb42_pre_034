package preProjectTeam34.questionLike.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import preProjectTeam34.questionLike.dto.QuestionLikeDto;
import preProjectTeam34.questionLike.repository.QuestionLikeRepository;

@Service
@RequiredArgsConstructor
public class QuestionLikeService {

    private final QuestionLikeRepository questionLikeRepository;
    // private final MemberRepository memberRepository
    // private final QuestionRepository questionRepository

    public void insert(QuestionLikeDto questionLikeDto) throws Exception{

    }

    public void delete(QuestionLikeDto questionLikeDto) throws Exception{

    }
}
