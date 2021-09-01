package MOOC_Spring.HelloRequestParams;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@SpringBootApplication
public class HelloRequestParamsApplication {
@GetMapping("/hello")
@ResponseBody
public String param1(@RequestParam Map<String,String> names){
    return "Hello " + names.values();
}
@GetMapping("/params")
@ResponseBody
public String param2(@RequestParam Map<String,String> names){
    return (names.toString());
//    return (names.keySet().toString()) + " = " + (names.values());
}
	public static void main(String[] args) {
		SpringApplication.run(HelloRequestParamsApplication.class, args);
	}

}
