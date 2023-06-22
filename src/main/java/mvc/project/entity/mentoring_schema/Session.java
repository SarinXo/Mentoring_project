package mvc.project.entity.mentoring_schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessions_tab")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "time_start")
    private String timeStart;
    @Column(name = "time_finish")
    private String timeFinish;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker workerId;

    @OneToMany(mappedBy = "sessionId", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Screenshot> screenshotList = new ArrayList<>();

    public Session(Integer id, String timeStart, String timeFinish, Worker workerId) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.workerId = workerId;
    }

    public String timeStart() {
        return timeStart;
    }

    public String timeFinish() {
        return timeFinish;
    }

    public Worker workerId() {
        return workerId;
    }

    public List<Screenshot> screenshotList() {
        return screenshotList;
    }
}
