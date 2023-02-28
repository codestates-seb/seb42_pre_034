package preProjectTeam34.tags.tagsPage;

public class TagsPageRequest extends CustomPageRequest<TagSortingType> {
    public TagsPageRequest(int page, int size, TagSortingType sortingType){
        super(page, size, sortingType);
    }


}
