package questionLike.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import questionLike.dto.QuestionLikeDto;
import questionLike.repository.QuestionLikeRepository;

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
