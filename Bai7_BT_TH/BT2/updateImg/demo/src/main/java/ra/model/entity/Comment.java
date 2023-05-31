package ra.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgOfDay;
    private String author;
    private String comment;
    private int star;
    private long countStar;
    private String date;

    public Comment() {
    }

    public Comment(String imgOfDay, String author, String comment, int star, long countStar) {
        this.imgOfDay = imgOfDay;
        this.author = author;
        this.comment = comment;
        this.star = star;
        this.countStar = countStar;
        this.date=LocalDate.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgOfDay() {
        return imgOfDay;
    }

    public void setImgOfDay(String imgOfDay) {
        this.imgOfDay = imgOfDay;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", imgOfDay='" + imgOfDay + '\'' +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", star=" + star +
                ", countStar=" + countStar +
                ", date='" + date + '\'' +
                '}';
    }
}
