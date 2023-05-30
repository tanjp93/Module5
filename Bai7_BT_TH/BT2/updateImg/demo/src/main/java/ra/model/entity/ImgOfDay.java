package ra.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "imgOfDay")
public class ImgOfDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pathImg;
    @Column(name = "dateFollowImg",columnDefinition = "date")
    private String date;
    @OneToMany(mappedBy ="imgOfDay",targetEntity = Comment.class)
    private Set<Comment> commentList;

    public ImgOfDay() {
    }

    public ImgOfDay(String pathImg, Set<Comment> commentList) {
        this.pathImg = pathImg;
        this.date = LocalDate.now().toString();
        this.commentList = commentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "ImgOfDay{" +
                "id=" + id +
                ", pathImg='" + pathImg + '\'' +
                ", date='" + date + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
