package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.service.comment.ICommentService;

@Controller
@RequestMapping("/")
public class homeController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("")
    public String toHome(){
        return "index";
    }
}
