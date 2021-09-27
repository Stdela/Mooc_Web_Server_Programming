/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part2.Airports_and_Aircrafts;

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
public class AirportController {
    @Autowired
    AircraftRepository aircrep;
    @Autowired
    AirportRepository airprep;
    
    @GetMapping("/airports")
    public String page(Model model) {
       
        model.addAttribute("airports", airprep.findAll());
        return "airports";
    }
    
    @PostMapping("/airports")
    public String create(@RequestParam String identifier, @RequestParam String name){
        Airport ap = new Airport();
        ap.setName(name);
        ap.setIdentifier(identifier);
        airprep.save(ap);
       return "redirect:/airports";
    }
    @PostMapping("/aircrafts/{aircraftID}/airports")
    public String adding(@PathVariable Long AircraftID, @RequestParam Long airportid ){
        Airport ap = airprep.getOne(airportid);
        Aircraft a = aircrep.getOne(AircraftID);
        a.setAirport(ap);
        aircrep.save(a);
        return "redirect:/aircrafts";
    }

}
