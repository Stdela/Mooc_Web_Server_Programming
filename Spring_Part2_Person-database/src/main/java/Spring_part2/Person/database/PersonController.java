/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.Person.database;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author delam
 */
@Controller
public class PersonController {
    @Autowired
    private PersonRepository personrepository;
    

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list", personrepository.findAll());
        return "index";
    }
    @PostMapping("/")
    public String create(@RequestParam String name,
            @RequestParam String surname){
        if (!name.trim().isEmpty()) {
            personrepository.save(new Person(name.trim(),surname.trim()));
        }
        return "redirect:/";
    }
}
