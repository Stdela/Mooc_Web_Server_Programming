/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part4.HelloSession;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author delam
 */
@Controller
public class HelloSessionController {
    @GetMapping("*")
    @ResponseBody
    public String greet(HttpSession session){
        int visits = 0;
        if (session.getAttribute("count")!= null) {
            visits= (int) session.getAttribute("count");
            
        }
        if (visits > 0) {
            return "Hello again";
        }
        visits ++;
        session.setAttribute("count", visits);
        
        
       
        return "Welcome";
    }
    
}
