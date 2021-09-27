/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part3.SimpleBanking;

import java.util.ArrayList;
import java.util.List;
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
public class SimpleBankingController {
    @Autowired
private  AccountRepository accountrep;
    @Autowired
    private ClientRepository clientrep;
    
    @GetMapping("/welcome")
    public String List(Model model){
        model.addAttribute("client", clientrep.findAll());
        return "accounts";
                
//    public String buidSentence(){
//     Account  a = accountrep.getOne(1L);
//       Client c = new Client("Santiago", (List<Account>) a);
//       clientrep.save(c);
//          return "index";
    }
    
    @PostMapping("/welcome")
    public String createAccount(@RequestParam String name, @RequestParam String accountName){
        List<Account> accList = new ArrayList<>();
        Account c = new Account(accountName, 0);
        accList.add(c);
        accountrep.save(c);
        clientrep.save( new Client( name,accList));
        return "redirect:/welcome";
    }
    
    @GetMapping("/welcome/{id}")
    public String getOne(Model model, @PathVariable Long id){
    model.addAttribute("client", clientrep.getOne(id));
    return "indexid";
    }
    
//    
//}//    public String getOne(Model model, @PathVariable Long id){
//    model.addAttribute("account", accountrep.getOne(id));
//    return "indexid";
//    
//    @PostMapping("welcome/{id}/name")
//    public String associate(@PathVariable Long id, @RequestParam String name ){
//        Account a = accountrep.getOne(id);
//        Client c = new Client(name, (List<Account>) a);
//        clientrep.save(c);
//        return "redirect:/welcome/" +id;
//        
//    }
//    
    
    
    
}
