package preProjectTeam34.answer;

import org.springframework.stereotype.Service;

//TODO: Transaction 확인.
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    private final QuestionService questionservice;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer)
}
