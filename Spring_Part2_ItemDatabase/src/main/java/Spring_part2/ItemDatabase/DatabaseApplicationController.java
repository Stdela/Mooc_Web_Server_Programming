/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.ItemDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Add functionality to the application that allows you to save objects to the
 * database using a predefined form. Therefore, implement a method appropriate
 * for the controller class (check the parameter or parameter names on the HTML
 * page) and take advantage of the methods provided by the ItemRepository
 * interface.
 *
 * @author delam
 */
@Controller
public class DatabaseApplicationController {

    @Autowired
    private ItemRepository ItemRepository;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list", ItemRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String create(@RequestParam String name) {
        if (!name.trim().isEmpty()) {
            ItemRepository.save(new Item(name.trim()));
        }
        return "redirect:/";
    }

}
