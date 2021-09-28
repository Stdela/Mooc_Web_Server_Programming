/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part3.Exams_and_questions;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author delam
 */
@Controller
public class ExamController {
     @Autowired
    QuestionRepository qr;
    @Autowired
    ExamRepository er;
    
    @GetMapping("/exams")
    public String page(Model model) {   
        Pageable pageable;
         pageable = PageRequest.of(0,10, Sort.by("date").descending());
        model.addAttribute("exams",er.findAll(pageable) );
        return "exams";
    }
@PostMapping("/exams")
    public String addExam(@RequestParam String subject,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        er.save(new Exam(subject, date, new ArrayList()));

        return "redirect:/exams";
    }
    
     @GetMapping("/exams/{id}")
    public String viewExam(Model model, @PathVariable Long id) {
        model.addAttribute("exam", er.getOne(id));
        model.addAttribute("questions", qr.findAll());
        return "exam";
    }
    @PostMapping("/exams/{examId}/questions/{questionId}")
    public String associate(@PathVariable Long examId, @PathVariable Long questionId){
        Question question = qr.getOne(questionId);
        Exam exam = er.getOne(examId);
        exam.getQuestions().add(question);
        er.save(exam);
        return "redirect:/exams";
    }
    
}
