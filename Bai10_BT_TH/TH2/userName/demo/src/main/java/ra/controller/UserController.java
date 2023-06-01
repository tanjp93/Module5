package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
//        Cookie cookie = new Cookie("setUser", setUser);
//        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null)
                setUser = user.getEmail();

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }

//    @RequestMapping("/login")
//    public String Index(Model model) {
//        model.addAttribute("user",new User());
//        return "login";
//    }
//
//    @PostMapping("/dologin")
//    public String doLogin(@ModelAttribute("user") User user, HttpServletResponse response, Model model,HttpServletRequest request) {
//        //implement business logic
//        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
//            Cookie cookie = new Cookie("setUser", user.getEmail());
//            cookie.setMaxAge(5 * 60);
//            response.addCookie(cookie);
//            return "result";
//        } else {
//             model.addAttribute("message","Login failed");
//            return "login";
//        }
//    }
}