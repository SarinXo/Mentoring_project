package mvc.project.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc.project.entity.mentoring_schema.Worker;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerInfoDto {

    private Integer id;
    private String fio;
    private String job;
    private LocalTime time4screenshots;
    private List<SessionDto> sessionList = new ArrayList<>();

    public WorkerInfoDto(Worker worker){
        this.id = worker.getId();
        this.fio = worker.getFio();
        this.job = worker.getJob();
        this.time4screenshots = worker.getTime4screenshots();
        this.sessionList = worker.sessionList().stream().map(SessionDto::new).collect(Collectors.toList());
    }

    public Integer id() {
        return id;
    }

    public String fio() {
        return fio;
    }

    public String job() {
        return job;
    }

    public LocalTime time4screenshots() {
        return time4screenshots;
    }

    public List<SessionDto> sessionList() {
        return sessionList;
    }
}
