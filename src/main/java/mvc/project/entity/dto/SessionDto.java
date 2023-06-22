package mvc.project.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc.project.entity.mentoring_schema.Session;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionDto {
    private Integer workerId;
    private String timeStart;
    private String timeFinish;

    public SessionDto(Session session){
        this.workerId = session.workerId().id();
        this.timeStart = session.timeStart();
        this.timeFinish = session.timeFinish();
    }


    public Integer workerId() {
        return workerId;
    }

    public String timeStart() {
        return timeStart;
    }

    public String timeFinish() {
        return timeFinish;
    }
}
