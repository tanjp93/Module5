package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category",targetEntity = MyBlog.class, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("category")
    private Set<MyBlog> myBlogList;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MyBlog> getMyBlogList() {
        return myBlogList;
    }

    public void setMyBlogList(Set<MyBlog> myBlogList) {
        this.myBlogList = myBlogList;
    }

}
