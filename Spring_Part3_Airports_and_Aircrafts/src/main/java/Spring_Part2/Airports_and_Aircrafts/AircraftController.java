
package Spring_Part2.Airports_and_Aircrafts;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author delam
 */
@Controller
public class AircraftController {
    @Autowired
    AirportRepository airprep;
    @Autowired
    AircraftRepository aircrep;
    
    @GetMapping("/aircrafts")
    public String page(Model model) {
        model.addAttribute("aircrafts", aircrep.findAll());
        model.addAttribute("airports", airprep.findAll());
        return "aircrafts";
        
    }
    @PostMapping("/aircrafts")
    public String create(@RequestParam String name){

        Aircraft ac = new Aircraft();
        ac.setName(name);
        aircrep.save(ac);
        return"redirect:/aircrafts";
    }
    
    
    
    
}
