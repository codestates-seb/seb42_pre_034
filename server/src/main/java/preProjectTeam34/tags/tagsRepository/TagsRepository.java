package preProjectTeam34.tags.tagsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import preProjectTeam34.tags.entity.Tags;

import java.util.List;
import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tags, Long> {

    Optional<Tags> findByName(String tagName);
    List<Tags> findAllByNameIn(List<String> tagNames);


}
