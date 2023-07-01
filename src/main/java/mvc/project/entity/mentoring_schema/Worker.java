package mvc.project.entity.mentoring_schema;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    private LocalTime time4screenshots;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public List<Session> sessionList() {
        return sessionList;
    }

    @OneToMany(mappedBy = "workerId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Session> sessionList = new ArrayList<>();


    public Worker(Integer id, String fio, String photoReference, String email, String password,
                  String job, String city, LocalTime time4screenshots, Boolean isDeleted) {
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
                  String job, String city, LocalTime time4screenshots) {
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

    public Worker(String fio, String email, String password, String job, String city, LocalTime time4screenshots) {
        this.fio = fio;
        this.email = email;
        this.password = password;
        this.job = job;
        this.city = city;
        this.time4screenshots = time4screenshots;
        this.isDeleted = false;
    }

    public Integer getId() {
        return id;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public String getFio() {
        return fio;
    }

    public String getJob() {
        return job;
    }

    public LocalTime getTime4screenshots() {
        return time4screenshots;
    }

    public String photoReference() {
        return photoReference;
    }

    public String getCity() {
        return city;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTime4screenshots(LocalTime time4screenshots) {
        this.time4screenshots = time4screenshots;
    }
}
