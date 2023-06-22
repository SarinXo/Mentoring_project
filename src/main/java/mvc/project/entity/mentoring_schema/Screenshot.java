package mvc.project.entity.mentoring_schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screenshots_tab")
public class Screenshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session sessionId;

    @Column(name = "screenshot_reference")
    private String screenshotReference;

    public Integer id() {
        return id;
    }

    public Session sessionId() {
        return sessionId;
    }

    public String screenshotReference() {
        return screenshotReference;
    }
}
