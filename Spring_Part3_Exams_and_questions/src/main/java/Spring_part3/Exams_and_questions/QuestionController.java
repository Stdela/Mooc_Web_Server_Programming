/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part3.Exams_and_questions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author delam
 */
@Controller
public class QuestionController {
    @Autowired
    QuestionRepository qr;
    @Autowired
    ExamRepository ar;
    
    
    @RequestMapping("/questions")
    public String page(Model model) {
        model.addAttribute("questions", qr.findAll());
        return "questions";
    }
    
    @PostMapping("/questions")
    public String create (@RequestParam String title, @RequestParam String content){
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        qr.save(question);
        return "redirect:/questions";
    }
    
    
}
