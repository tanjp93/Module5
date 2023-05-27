package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Customer;
import ra.model.service.ICustomerService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String toHome(){
        return "index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("newCustomer", new Customer());
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView saveCustomer(@ModelAttribute("newCustomer") Customer customer) {
        customerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
}
