/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.HelloPathVariables;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author delam
 */
@Controller
public class PathsController {

    private Map<String, Item> items;

    public PathsController() {
        this.items = new TreeMap<>();
        this.items.put("default", new Item("Hat", "default"));
        this.items.put("ascot", new Item("Ascot cap", "hat"));
        this.items.put("balaclava", new Item("Balaclava", "hat"));
        this.items.put("bicorne", new Item("Bicorne", "hat"));
        this.items.put("busby", new Item("Busby", "hat"));
        this.items.put("capotain", new Item("Capotain", "hat"));
        this.items.put("homburg", new Item("Homburg", "hat"));
        this.items.put("montera", new Item("Montera", "hat"));
    }

  @GetMapping("/")
    public String home(Model model) {
        return getHat(model, "index");
    }

    @GetMapping("/{item}")
    public String getHat(Model model, @PathVariable String item) {
        if (!this.items.containsKey(item)) {
            item = "default";
        }

        model.addAttribute("item", this.items.get(item));
        return "index";
    }
}
