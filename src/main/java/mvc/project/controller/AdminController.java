package mvc.project.controller;

import lombok.AllArgsConstructor;
import mvc.project.entity.dto.WorkerForUserTableDto;
import mvc.project.entity.mentoring_schema.Worker;
import mvc.project.service.WorkerServiceConnectWithApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");;
    private Matcher matcher;
    private final WorkerServiceConnectWithApplication workerServiceConnectWithApplication;

    public AdminController(WorkerServiceConnectWithApplication workerServiceConnectWithApplication) {
        this.workerServiceConnectWithApplication = workerServiceConnectWithApplication;
    }

    @GetMapping("/home")
    public String home(){
        return "admin/home";
    }

    @ModelAttribute("workers4table1")
    public List<WorkerForUserTableDto> messages() {
        return workerServiceConnectWithApplication.findAllExistingWorkers4Table();
    }
    @GetMapping("/add_worker")
    public String addWorkerForm(@RequestParam(value = "error", required = false) String error,
                                Model model) {
        Worker worker = new Worker();
        model.addAttribute("error", error != null);
        model.addAttribute("worker", worker);
        return "admin/add_worker";
    }

    @PostMapping("/save_worker")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        if(isCorrectData(worker)) {
            workerServiceConnectWithApplication.saveWorker(worker);
        }
        return "redirect:/admin/add_worker";
    }

    private boolean isCorrectData(Worker worker){
        if(isNotCorrectEmail(worker.email())){
            return false;
        }
        //if(isNotCorrectTime()){
//
        //}
        return true;
    }

    private boolean isNotCorrectEmail(String email){
        return !pattern.matcher(email).matches();
    }

    //private boolean isNotCorrectTime(){
    //
    //}
//
}
