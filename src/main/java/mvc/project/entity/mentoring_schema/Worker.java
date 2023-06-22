package mvc.project.entity.mentoring_schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workers_tab")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fio;
    @Column(name = "photo_reference")
    private String photoReference;
    private String email;
    private String password;
    private String job;
    private String city;
    @Column(name = "time_4screenshots")
    private String time4screenshots;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public List<Session> sessionList() {
        return sessionList;
    }

    @OneToMany(mappedBy = "workerId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Session> sessionList = new ArrayList<>();


    public Worker(Integer id, String fio, String photoReference, String email, String password,
                  String job, String city, String time4screenshots, Boolean isDeleted) {
        this.id = id;
        this.fio = fio;
        this.photoReference = photoReference;
        this.email = email;
        this.password = password;
        this.job = job;
        this.city = city;
        this.time4screenshots = time4screenshots;
        this.isDeleted = isDeleted;
    }

    public Worker(Integer id, String fio, String photoReference, String email, String password,
                  String job, String city, String time4screenshots) {
        this.id = id;
        this.fio = fio;
        this.photoReference = photoReference;
        this.email = email;
        this.password = password;
        this.job = job;
        this.city = city;
        this.time4screenshots = time4screenshots;
        this.isDeleted = false;
    }

    public Integer id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public Boolean isDeleted() {
        return isDeleted;
    }

    public String fio() {
        return fio;
    }

    public String job() {
        return job;
    }

    public String time4screenshots() {
        return time4screenshots;
    }

    public String photoReference() {
        return photoReference;
    }

    public String city() {
        return city;
    }
}
