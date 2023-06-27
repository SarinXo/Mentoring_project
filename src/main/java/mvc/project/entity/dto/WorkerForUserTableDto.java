package mvc.project.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc.project.entity.mentoring_schema.Worker;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerForUserTableDto {
    private Integer id;
    private String fio;
    private String city;
    private String email;

    public WorkerForUserTableDto(Worker worker) {
        this.id = worker.id();
        this.fio = worker.fio();
        this.city = worker.city();
        this.email = worker.email();
    }

    public Integer id() {
        return id;
    }

    public String fio() {
        return fio;
    }

    public String city() {
        return city;
    }

    public String email() {
        return email;
    }
}
