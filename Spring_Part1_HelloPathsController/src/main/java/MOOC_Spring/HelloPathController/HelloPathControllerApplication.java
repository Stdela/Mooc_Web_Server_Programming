package MOOC_Spring.HelloPathController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HelloPathControllerApplication {
@GetMapping("/hellopath")
@ResponseBody
public String path(){
    return "Correct!";
}
@GetMapping("/goodbye")
@ResponseBody
public String goodbye(){
    return "Goodbye";
}

	public static void main(String[] args) {
		SpringApplication.run(HelloPathControllerApplication.class, args);
	}

}
