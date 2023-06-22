package mvc.project.service.Impl;

import lombok.AllArgsConstructor;
import mvc.project.entity.dto.WorkerInfoDto;
import mvc.project.entity.mentoring_schema.Worker;
import mvc.project.handler.exception.IncorrectLoginInformationException;
import mvc.project.handler.exception.NotFoundApiException;
import mvc.project.repository.WorkerRepository;
import mvc.project.service.WorkerServiceConnectWithApplication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerServiceConnectWithApplication {

    private final WorkerRepository workerRepository;

    @Override
    public Worker findWorkerByEmail(String email) throws NotFoundApiException{
        Worker worker = workerRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(worker)) {
            throw NotFoundApiException.Builder.notFoundApiException().build();
        }

        return worker;
    }

    @Override
    public WorkerInfoDto authInApp(String email, String password){
        Worker worker = workerRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(worker)) {
            throw NotFoundApiException.Builder.notFoundApiException().build();
        }

        if(!Objects.equals(worker.password(), password)
                || worker.isDeleted()){
            throw IncorrectLoginInformationException.Builder.
                    incorrectLoginInformationException().build();
        }

        return new WorkerInfoDto(worker);
    }


}
