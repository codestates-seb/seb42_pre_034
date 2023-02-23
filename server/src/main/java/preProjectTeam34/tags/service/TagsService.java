package preProjectTeam34.tags.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import preProjectTeam34.exception.BusinessLogicException;
import preProjectTeam34.exception.ExceptionCode;
import preProjectTeam34.tags.entity.Tags;
import preProjectTeam34.tags.tagsPage.TagsPageRequest;
import preProjectTeam34.tags.tagsRepository.TagsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TagsService {

    private final TagsRepository tagsRepository;

    public Tags findBy(String tagName){
        return findExistsTagsBy(tagName);
    }

    public List<Tags> findAllBy(List<String> tagNames){
        return tagsRepository.findAllByNameIn(
                tagNames.stream().map(String::toLowerCase).collect(Collectors.toList())
        );
    }

    public Page<Tags> findAll(TagsPageRequest pageRequest){
        return tagsRepository.findAllByOrderByNameAsc(pageRequest.unsorted());
    }

    private Tags findExistsTagsBy(String tagName){
        return tagsRepository.findByName(tagName.toLowerCase())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        //에러 코드 추후 수정 필요(모든 에러코드 종합 및 정리 필요할듯)
    }

}
