/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_Part4.GifRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author delam
 */
@Controller
public class GifController {

    @Autowired
    GifRepository gr;

    @GetMapping("/gifs")
    public String home() {
        return "redirect:/gifs/1";
    }

//    @GetMapping(path = "/gifs/{id}", produces = "image/gif")
    @GetMapping("gifs/{id}")
    public String welcome(@PathVariable Long id, Model model){
        model.addAttribute("size", gr.count());
        model.addAttribute("current", id);
        if (gr.getOne(id-1) != null) {
            model.addAttribute("previous" ,id-1);
        }
        if (gr.getOne(id+1) != null) {
            model.addAttribute("next" ,id+1);
        }
        return "gif";
    }
    
 @GetMapping(path = "/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] get(@PathVariable Long id) {
        return gr.getOne(id).getContent();
    }

    @PostMapping("/gifs")
    String create(@RequestParam("gif") MultipartFile Gif) throws Exception {
        Gif gif = new Gif();
        gif.setContent(Gif.getBytes());
        gr.save(gif);
        return "redirect:/gifs";
    }

//    @GetMapping(path = "/gifs/{id}", produces = "image/gif")
//    public void copyImage(OutputStream out) throws IOException{
//        Files.copy(Paths.get("C:/Users/delam/Documents/NetBeansProjects/GifRepository/src/main/resources/gif/josuke1.gif"),out);
}
