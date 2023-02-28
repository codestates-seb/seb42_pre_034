package preProjectTeam34.tags.tagsPage;

import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
public abstract class CustomPageRequest <E extends Enum<?>> {

    private final int page;
    private final int size;
    private final E sortType;

    public CustomPageRequest(int page, int size, E sortType){
        this.page = page;
        this.size = size;
        this.sortType = sortType;
        }

        public PageRequest of(Sort sort){
            return PageRequest.of(page, size, sort);
        }

        public PageRequest unsorted(){
            return of(Sort.unsorted());
        }



}
