package Spring_02.HelloObject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@SpringBootApplication
public class HelloObjectApplication {
/// The form does not work, my html skills are not up there yet, did my best!
    
    private List<Wizard> wizardObject;

    public HelloObjectApplication() {
        this.wizardObject = new ArrayList<>();
        this.wizardObject.add(new Wizard("Hat", "Pointy"));
        this.wizardObject.add(new Wizard("Party Hat", "Groovy"));
    }
    @GetMapping("/hola")
    public String home(Model model) {
        model.addAttribute("list", wizardObject);
        return "newhtml";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloObjectApplication.class, args);
    }

}
