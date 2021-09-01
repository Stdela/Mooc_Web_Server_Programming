package Part2.HelloThymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class HelloThymeleafApplication{ // and HTML practice  {
@GetMapping("/")
public String home(){
    return "index";
}
@GetMapping("/video1")
public String video(){
    return "video1";
}
	public static void main(String[] args) {
		SpringApplication.run(HelloThymeleafApplication.class, args);
	}

}
