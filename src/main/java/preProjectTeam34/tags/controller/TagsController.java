package preProjectTeam34.tags.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import preProjectTeam34.dto.MultiResponseDto;
import preProjectTeam34.dto.SingleResponseDto;
import preProjectTeam34.tags.dto.TagsDto;
import preProjectTeam34.tags.entity.Tags;
import preProjectTeam34.tags.mapper.TagsMapper;
import preProjectTeam34.tags.service.TagsService;
import preProjectTeam34.tags.tagsPage.TagsPageRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagsController {

    private final TagsService tagsService;
    private final TagsMapper tagsMapper;


    @GetMapping("/{name}")
    public ResponseEntity<?> getTag(@PathVariable("name") String tagName) {
        return new ResponseEntity<>(new SingleResponseDto<>(tagsService.findBy(tagName)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTags(TagsPageRequest pageRequest) {
        return getMultiResponseEntity(tagsService.findAll(pageRequest));
    }

    private ResponseEntity<?> getMultiResponseEntity(Page<Tags> page) {
        if (page.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<TagsDto.Response> responses = page.map(tagsMapper::tagsToResponse).toList();
            return new ResponseEntity<>(new MultiResponseDto<>(responses, page), HttpStatus.OK);
        }


    }
}
