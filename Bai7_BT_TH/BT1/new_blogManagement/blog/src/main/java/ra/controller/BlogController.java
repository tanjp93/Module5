package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.MyBlog;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IMyBlogService myBlogService;
    @GetMapping("")
    public String toHome(Model model){
        List<MyBlog> list=myBlogService.findAll();
        model.addAttribute("list",list);
        return "/index";
    }
    @GetMapping("/createBlog")
    public ModelAndView toAddBlog(){
        return new ModelAndView("/createBlog", "newBlog",new MyBlog());
    }
    @PostMapping("/addBlog")
    public String toAddBlog(@ModelAttribute("newBlog")MyBlog myBlog){
        String str=myBlog.getContent().substring(0,15);
        myBlog.setSummary(str);
        LocalDate date=LocalDate.now();
        myBlog.setDate(date);
        myBlogService.save(myBlog);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView toEditBlog(@PathVariable("id")String id){
        return new ModelAndView("/edit", "editBlog",myBlogService.findById(Long.valueOf(id)));
    }
    @PostMapping("update")
    public String toUpdate(@ModelAttribute("editBlog")MyBlog myBlog){
        myBlogService.save(myBlog);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String toDeleteBlog(@PathVariable("id")String id,Model model){
        model.addAttribute("message","Delete success");
        myBlogService.remove(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView toDetailBlog(@PathVariable("id")String id){
        return new ModelAndView("/detail", "detail",myBlogService.findById(Long.valueOf(id)));
    }
}
