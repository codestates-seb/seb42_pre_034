package preProjectTeam34.tags.entity;

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
    @Column(name = "tagsId", updatable = false)
    private Long tagsId;

    @Column(name = "name", unique = true, updatable = false, nullable = false)
    private String name;

    @Column(name = "content")
    private String content;

    public Tags(Long tagsId, String name, String content){
        this.tagsId = tagsId;
        this.name = name;
        this.content = content;
    }


}
