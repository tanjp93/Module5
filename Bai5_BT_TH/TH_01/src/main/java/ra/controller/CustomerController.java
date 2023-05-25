package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Customer;
import ra.model.service.customer.ICustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/")
    public ModelAndView listCustomers(){
        return new ModelAndView("index","customers",customerService.findAll());
    }
    @GetMapping("/create")
    public String  showFormCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/add";
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer")Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public  String editCustomer(Model model, @PathVariable("id") String id){
        Customer customer= customerService.findById(Long.valueOf(id));
        model.addAttribute("editCustomer",customer);
        return "/customer/edit";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("editCustomer")Customer customer){
        customerService.update(customer);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        customerService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}

