package mvc.project.service.Impl;

import lombok.AllArgsConstructor;
import mvc.project.entity.dto.WorkerForUserTableDto;
import mvc.project.entity.dto.WorkerInfoDto;
import mvc.project.entity.mentoring_schema.Worker;
import mvc.project.handler.exception.IncorrectLoginInformationException;
import mvc.project.handler.exception.NotFoundApiException;
import mvc.project.repository.WorkerRepository;
import mvc.project.service.WorkerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    @Override
    public Worker findWorkerByEmail(String email) throws NotFoundApiException{
        return workerRepository.findByEmail(email)
                .orElseThrow(() -> NotFoundApiException.Builder.notFoundApiException().build());
    }

    @Override
    public WorkerInfoDto authInApp(String email, String password) throws NotFoundApiException{
        //duple
        Worker worker = workerRepository.findByEmail(email).
                orElseThrow(() -> NotFoundApiException.Builder.notFoundApiException().build());

        if(!Objects.equals(worker.getPassword(), password)
                || worker.getIsDeleted()){
            throw IncorrectLoginInformationException.Builder.
                    incorrectLoginInformationException().build();
        }

        return new WorkerInfoDto(worker);
    }

    @Override
    public List<WorkerForUserTableDto> findAllExistingWorkers4Table(){
        List<Worker> workers = workerRepository.findAll();
        return findExistingWorkersWithConvert(workers);
    }

    private List<WorkerForUserTableDto> findExistingWorkersWithConvert(List<Worker> workers){
        List<WorkerForUserTableDto> newWorkers = new ArrayList<>();
        for (var worker:
             workers) {
            if(!worker.getIsDeleted())
                newWorkers.add( new WorkerForUserTableDto(worker) );
        }
        return newWorkers;
    }

    @Override
    public void saveWorker(Worker worker){
        workerRepository.save(worker);
    }

    public void deleteWorkerById(int id){
        workerRepository.deleteById(id);
    }

    @Override
    public Worker findById(Integer id) throws NotFoundApiException{
        return workerRepository.findById(id)
                .orElseThrow(() -> NotFoundApiException.Builder.notFoundApiException().build());
    }

    @Override
    public Page<Worker> findPaginated(int pageNo, int pageSize){
        Pageable page = PageRequest.of(pageNo-1, pageSize);
        return workerRepository.findAll(page);
    }
}
