/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part2.Todo_Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author delam
 */
@Controller
public class ToDoController {

    @Autowired
   private TaskRepository taskrepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", taskrepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String create(@RequestParam String task) {
            taskrepository.save(new Task(task,0));
        return "redirect:/";
    }
    
    @GetMapping("/{id}")
    public String page(Model model, @PathVariable Long id){
        Task task1 = taskrepository.getOne(id);
        task1.setVisits(task1.getVisits()+1);
        task1 = taskrepository.save(task1);
        
        model.addAttribute("task",task1);
        return "page";
        
    
}

}
