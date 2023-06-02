package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "myBlog")
public class MyBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("myBlogList")
    private Category category;
    @Column(nullable = false)
    private String title;
    @Column(name="content",columnDefinition = "text")
    private String content;
    private LocalDate date;

    public MyBlog() {
    }

    public MyBlog(Category category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyBlog[" +
                "id=" + id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ']';
    }
}
