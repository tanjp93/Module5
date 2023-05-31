package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Comment;
import ra.model.service.comment.ICommentService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class homeController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public String toHome(@RequestParam("sortBy") Optional<String> sortBy, ModelMap model, Pageable pageable) {
        Sort sort = null;
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "date-ASC":
                    sort = Sort.by("date").ascending();
                    break;
                case "date-DESC":
                    sort = Sort.by("date").descending();
                    break;
                case "star-ASC":
                    sort = Sort.by("star").ascending();
                    break;
                case "star-DESC":
                    sort = Sort.by("star").descending();
                    break;
                default:
                    break;
            }
        } else sort = Sort.by("date").descending().and(Sort.by("star").ascending());
        Page<Comment> comments = commentService.findAll(pageable, sort);
        model.addAttribute("comments", comments);
        return "index";
    }

    @GetMapping("/toCreate")
    public ModelAndView toCreate() {
        return new ModelAndView("addComment", "newComment", new Comment());
    }
    @PostMapping("/addComment")
    public String doCreateComment(@ModelAttribute("newComment")Comment comment){
        System.out.println(comment);
        String date= LocalDate.now().toString();
        comment.setDate(date);
        commentService.save(comment);
        return "redirect:/";
    }
    @GetMapping("/viewDetailComment/{id}")
    public ModelAndView toViewDetail(@PathVariable("id")String id){
        Comment comment= commentService.findById(Long.valueOf(id)).get();
        return new ModelAndView("/detailComment","comment",comment);
    }
    @PostMapping("/updateComment")
    public ModelAndView toVoteStar(@ModelAttribute("comment")Comment comment){
        System.out.println("comment>>>.."+comment);
        comment.setCountStar(comment.getCountStar()+1);
        System.out.println("comment>>>.."+comment);
        commentService.save(comment);
        return new ModelAndView("detailComment","comment",comment);
    }
}
