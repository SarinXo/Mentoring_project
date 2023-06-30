package mvc.project.controller;

import lombok.AllArgsConstructor;
import mvc.project.entity.dto.WorkerInfoDto;
import mvc.project.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GET")
@AllArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping("/authInApp/worker/{email}/{password}")
    public WorkerInfoDto getWorkerInfo(
            @PathVariable("email") String email,
            @PathVariable("password") String password){
        return workerService.authInApp(email, password);
    }

    @GetMapping("/sample")
    public String sample(){
        return "sample";
    }

}
