package mvc.project.controller;

import mvc.project.entity.dto.WorkerForUserTableDto;
import mvc.project.entity.mentoring_schema.Worker;
import mvc.project.service.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static mvc.project.checker.AddWorkerChecker.isCorrectData;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final WorkerService workerService;

    public AdminController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/home")
    public String home(){
        return "admin/home";
    }

    @ModelAttribute("workers4table1")
    public List<WorkerForUserTableDto> messages() {
        return workerService.findAllExistingWorkers4Table();
    }
    @GetMapping("/add_worker")
    public String addWorkerForm(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "ok", required = false) String ok,
                                Model model) {
        Worker worker = new Worker();
        worker.setIsDeleted(false);
        model.addAttribute("error", error != null);
        model.addAttribute("ok", error != null);
        model.addAttribute("worker", worker);
        return "admin/add_worker";
    }

    @PostMapping("/save_worker")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        if(isCorrectData(worker)) {
            workerService.saveWorker(worker);
            return "redirect:/admin/add_worker?ok";
        }
        return "redirect:/admin/add_worker?error";
    }

    @GetMapping("/update_worker/{id}")
    public String updateWorker(@PathVariable ( value = "id") Integer id, Model model) {
        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        return "/admin/update_worker";
    }

}
