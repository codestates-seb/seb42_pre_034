package tags;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagsId;

    private String name;

    private String content;

    public Tags(Long tagsId, String name, String content){
        this.tagsId = tagsId;
        this.name = name;
        this.content = content;
    }


}
