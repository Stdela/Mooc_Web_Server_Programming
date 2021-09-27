/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.HelloMultiplePagesmove;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author delam
 */
@Controller
public class HelloPagesController {

    Map<String, Item> items;

    public HelloPagesController() {
        this.items = new TreeMap<>();
        this.items.put("default", new Item("Normal Hat", "standard"));
    }

    @GetMapping("/")
    public String home(Model model) {
         model.addAttribute("items", this.items.values());
        return "index";
    }

    @GetMapping("/{item}")
      public String single(Model model, @PathVariable String item) {
        if (!this.items.containsKey(item)) {
            return "redirect:/";
        }

        model.addAttribute("item", this.items.get(item));
        return "single";
    }

    @PostMapping("/")
    public String post(@RequestParam String name, @RequestParam String type) {
        Item item = new Item(name, type);
        this.items.put(item.getName().trim(), item);
        return "redirect:/";
    }
}
