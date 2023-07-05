package mvc.project.controller;

import mvc.project.entity.dto.WorkerForUserTableDto;
import mvc.project.entity.mentoring_schema.Worker;
import mvc.project.service.WorkerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static mvc.project.checker.AddWorkerChecker.isCorrectData;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final WorkerService workerService;
    private final int DEFAULT_PAGE_NUMBER = 1;
    private final int DEFAULT_PAGE_SIZE   = 5;

    public AdminController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "successUpdate", required = false) String error,
                       @RequestParam(value = "successDeleted", required = false) String ok,
                       Model model){
        model.addAttribute("successUpdate", error != null);
        model.addAttribute("successDeleted", error != null);
        return findPagination(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE, model);
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

    @GetMapping("/update/{id}")
    public String updateWorker(@RequestParam(value = "error", required = false) String error,
                               @PathVariable(value = "id") int id,
                               Model model) {
        Worker worker = workerService.findById(id);
        model.addAttribute("worker", worker);
        model.addAttribute("error", error != null);
        return "admin/update_worker";
    }

    @PostMapping("/update")
    public String updateWorker(@ModelAttribute("worker") Worker worker) {
        if (isCorrectData(worker)) {
            workerService.saveWorker(worker);
            return "redirect:/admin/home?successUpdate";
        }
        return "redirect:/admin/update_worker?error";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable (value = "id") int id) {
        this.workerService.deleteWorkerById(id);
        return "redirect:/admin/home?successDeleted";
    }

    @GetMapping("/page/{pageNo}/{pageSize}")
    public String findPagination(@PathVariable("pageNo") int pageNo,
                                 @PathVariable("pageSize") int pageSize,
                                 Model model){
        Page<Worker> page = workerService.findPaginated(pageNo, pageSize);
        List<Worker> currentWorkersPage = page.getContent();

        model.addAttribute("currentPage",   pageNo);
        model.addAttribute("pageSize",      pageSize);
        model.addAttribute("totalPages",    page.getTotalPages());
        model.addAttribute("totalElements", page.getTotalElements());
        model.addAttribute("curPage",       currentWorkersPage);

        return "admin/home";
    }
}
