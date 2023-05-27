package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Feedback;
import ra.model.service.FeedbackServiceIMPL;
import ra.model.service.IFeedbackService;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping("/")
    public  String toHome(Model model){
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "index";
    }
    @GetMapping("/createFeedback")
    public  String toCreateFeedback(Model model){
        model.addAttribute("newFeedback",new Feedback());
        return "/addFeedback";
    }

    @PostMapping("/addFeedback")
    public String addFeedback(@ModelAttribute("newFeedback")Feedback feedback){
        feedback.setDate(LocalDate.now());
        feedbackService.save(feedback);
        return "redirect:/";
    }
    @GetMapping("/countStar/{id}")
    public String giveStar(@PathVariable("id")String id){
        Feedback feedback= feedbackService.findById((int) Long.parseLong(id));
        feedback.setCountStar(feedback.getCountStar()+1);
        feedbackService.update(feedback);
        return "redirect:/";
    }
}
