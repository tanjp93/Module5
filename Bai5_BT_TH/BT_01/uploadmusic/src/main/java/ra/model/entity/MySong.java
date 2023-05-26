package ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name="MySong")
public class MySong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String pathSong;

    public MySong() {
    }

    public MySong(long id, String name, String pathSong) {
        this.id = id;
        this.name = name;
        this.pathSong = pathSong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }

    @Override
    public String toString() {
        return "MySong{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pathSong='" + pathSong + '\'' +
                '}';
    }
}
