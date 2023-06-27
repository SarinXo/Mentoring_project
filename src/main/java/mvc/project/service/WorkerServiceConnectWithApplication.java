package mvc.project.service;

import mvc.project.entity.dto.WorkerForUserTableDto;
import mvc.project.entity.dto.WorkerInfoDto;
import mvc.project.entity.mentoring_schema.Worker;

import java.util.List;

public interface WorkerServiceConnectWithApplication {

    Worker findWorkerByEmail(String email);
    WorkerInfoDto authInApp(String email, String password);

    void saveWorker(Worker worker);

    List<WorkerForUserTableDto> findAllExistingWorkers4Table();
}
