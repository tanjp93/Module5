package ra.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = MyBlog.class)
    private List<MyBlog> myBlogList;

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

    public List<MyBlog> getMyBlogList() {
        return myBlogList;
    }

    public void setMyBlogList(List<MyBlog> myBlogList) {
        this.myBlogList = myBlogList;
    }

    @Override
    public String toString() {
        return "Category[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myBlogList=" + myBlogList +
                ']';
    }
}
