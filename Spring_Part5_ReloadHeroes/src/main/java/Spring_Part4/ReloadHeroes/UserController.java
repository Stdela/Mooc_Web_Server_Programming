/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part4.ReloadHeroes;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author delam
 */
@Controller
public class UserController {

    @Autowired
    UserRepository ur;
    @Autowired
    HttpSession httpservice;

    @GetMapping("/index")
    public String page(Model model) {
        User user = new User();

        if (httpservice.getAttribute("name") != null) {
           String name =(String) httpservice.getAttribute("name");
           user = ur.findByName(name);
           user.setVisits(user.getVisits()+1);
           ur.save(user);
        
           

        } else {

            user.setName(UUID.randomUUID().toString());
            user.setVisits(1);
            ur.save(user);
        }
        
        Pageable pageable = PageRequest.of(0, 5, Sort.by("visits").descending());
        model.addAttribute("hero", ur.findAll(pageable));
        return "index";
    }

}
