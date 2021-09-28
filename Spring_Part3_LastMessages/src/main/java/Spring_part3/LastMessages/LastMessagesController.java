/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part3.LastMessages;

import java.time.LocalDateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author delam
 */
@Controller
public class LastMessagesController {
    @Autowired
    private  MessageRepository messageRep;
    @GetMapping("/")
    public String page(Model model) {
//        Pageable pageable =  PageRequest.of(0,5, Sort.by("messages").descending());
         Pageable pageable1;
        pageable1 = PageRequest.of(0, 5, Sort.by("now").descending());
        model.addAttribute("message", messageRep.findAll(pageable1));
        return "index";
    }
    @PostMapping("/")
    public String create(@RequestParam String text ){
      Messages message = new Messages();
      message.setMessage(text);
      messageRep.save(message);
      return "redirect:/";
    }
    
}
