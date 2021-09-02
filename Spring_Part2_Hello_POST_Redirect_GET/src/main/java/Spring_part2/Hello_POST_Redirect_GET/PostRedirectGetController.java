/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.Hello_POST_Redirect_GET;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author delam
 */
@Controller


public class PostRedirectGetController {

    private List<String> list;

    public PostRedirectGetController() {
        this.list = new ArrayList<>();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", list);
        return "index";
    }

    @PostMapping("/")
    public String post(@RequestParam String data) {
        if (!data.trim().isEmpty()) {
            list.add(data);
        }

        return "redirect:/";
    }

}

