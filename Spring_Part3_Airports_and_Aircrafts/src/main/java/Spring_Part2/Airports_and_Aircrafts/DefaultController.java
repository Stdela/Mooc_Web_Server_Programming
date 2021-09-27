/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part2.Airports_and_Aircrafts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author delam
 */
@Controller
public class DefaultController {
    
    @GetMapping("*")
    public String Pagedefault() {
        return "menu";
    }
    
}
