package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.User;

import javax.validation.Valid;

@Controller
public class homeController {
    @GetMapping("/")
    public String toRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }else {
            model.addAttribute("user", user);
            return "result";
        }
    }
}
