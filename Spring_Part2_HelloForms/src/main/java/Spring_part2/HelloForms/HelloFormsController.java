/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.HelloForms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloFormsController {
    private String content = "Hello world!";

    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("content", content);
        return "index";
    }
   
     @PostMapping("/")
    public String post(@RequestParam String content) {
        this.content = content;
        // opimme tämän "redirect:/"-loitsun merkityksen ihan kohta!
        return "redirect:/";
    }
}
 
