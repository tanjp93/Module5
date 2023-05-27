package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Customer;
import ra.model.service.ICustomerService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/")
    public String toHome(Model model){
        model.addAttribute("customers",customerService.findAll());

        return "index";
    }
    @GetMapping("/create")
    public String toAdd(Model model){
        model.addAttribute("newCustomer",new Customer());
        return "/add";
    }
    @PostMapping("add")
    public String doAdd(@ModelAttribute("newCustomer")Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String toEdit(Model model, @PathVariable String id){
        model.addAttribute("editCustomer",customerService.findById(Long.valueOf(id)));
        System.out.println(" model.addAttribute(editCustomer,customerService.findById(Long.valueOf(id)))>>>"+ model.addAttribute("editCustomer",customerService.findById(Long.valueOf(id))));
        return "/edit";
    }
    @PostMapping("/update")
    public String toUpdate(@ModelAttribute("editCustomer")Customer updateCus){
        customerService.save(updateCus);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String toDelete(@PathVariable String id){
        customerService.remove(Long.valueOf(id));
        return "redirect:/";
    }
}
