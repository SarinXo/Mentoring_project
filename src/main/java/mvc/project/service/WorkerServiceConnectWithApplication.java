package mvc.project.service;

import mvc.project.entity.dto.WorkerInfoDto;
import mvc.project.entity.mentoring_schema.Worker;

public interface WorkerServiceConnectWithApplication {

    Worker findWorkerByEmail(String email);
    WorkerInfoDto authInApp(String email, String password);
}
