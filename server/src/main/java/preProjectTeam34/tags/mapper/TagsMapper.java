package preProjectTeam34.tags.mapper;

import org.mapstruct.Mapper;
import preProjectTeam34.tagQuestion.TagsQuestion;
import preProjectTeam34.tags.dto.TagsDto;
import preProjectTeam34.tags.entity.Tags;

@Mapper(componentModel = "spring")
public interface TagsMapper {

    TagsDto.Response tagsToResponse(Tags tags);

    default TagsDto.Response map(TagsQuestion tagsQuestion){
        return tagsToResponse(tagsQuestion.getTags());
    }
}
