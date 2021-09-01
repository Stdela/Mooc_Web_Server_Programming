package Mooc_Spring.HelloModel;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SpringBootApplication
public class HelloModelApplication {
    @GetMapping("/")
    public String home(Model model,
            @RequestParam String title,
            @RequestParam String person) {
        model.addAttribute("title", title);
        model.addAttribute("person", person);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloModelApplication.class, args);
    }

}
