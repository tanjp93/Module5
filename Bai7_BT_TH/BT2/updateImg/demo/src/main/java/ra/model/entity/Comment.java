package ra.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="pathImg_id")
    private ImgOfDay imgOfDay;
    private String author;
    private String feedback;
    private int star;
    private  long countStar;
    private LocalDate date;

    public Comment() {
    }
    public Comment( ImgOfDay imgOfDay, String author, String feedback, int star, long countStar) {
        this.imgOfDay = imgOfDay;
        this.author = author;
        this.feedback = feedback;
        this.star = star;
        this.countStar = countStar;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImgOfDay getImg() {
        return imgOfDay;
    }

    public void setImg(ImgOfDay imgOfDay) {
        this.imgOfDay = imgOfDay;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public long getCountStar() {
        return countStar;
    }

    public void setCountStar(long countStar) {
        this.countStar = countStar;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", imgOfDay=" + imgOfDay +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", star=" + star +
                ", countStar=" + countStar +
                ", date=" + date +
                '}';
    }
}
