package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.entity.MyBlog;
import ra.model.service.category.ICategoryService;
import ra.model.service.myBlog.IMyBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BlogController {
    @Autowired
    private IMyBlogService myBlogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    Iterable<Category> getListCategory() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public String toHome(@RequestParam("sortBy") Optional<String> sortBy, ModelMap model, Pageable pageable) {
        Sort sort = null;
        if (sortBy.isPresent()) {
            switch (sortBy.get()) {
                case "title-ASC":
                    sort=Sort.by("title").ascending();
                    break;
                case "title-DESC":
                    sort=Sort.by("title").descending();
                    break;
                case "date-ASC":
                    sort=Sort.by("date").ascending();
                    break;
                case "date-DESC":
                    sort=Sort.by("date").descending();
                    break;
                default:
                    break;
            }
        }
        else {
            sort = Sort.by("title").ascending().and(Sort.by("date").ascending());
        }
        Page<MyBlog> list=myBlogService.findAll(pageable,sort);
        model.addAttribute("list",list);
        return "/index";
    }

    @GetMapping("/createBlog")
    public ModelAndView toCreateBlog() {
        return new ModelAndView("createBlog", "myBlog", new MyBlog());
    }

    @PostMapping("/add")
    public String doCreate(@ModelAttribute("myBlog") MyBlog myBlog) {
        System.out.println("myBlog>>>>" + myBlog);
        myBlogService.save(myBlog);
        return "redirect:/";
    }
//
    @GetMapping("/blogList")
    public ResponseEntity<List<MyBlog>>listBlogFollowCategoryId(@RequestParam("categoryId")Long id){
        List<MyBlog>myBlogs= (List<MyBlog>) myBlogService.findMyBlogListByCategoryId(id);
        if (myBlogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(myBlogs, HttpStatus.OK);
    }
    @GetMapping("/blogDetail/{id}")
    public ResponseEntity<MyBlog> findBlogDetail(@PathVariable("id") Long id){
        Optional<MyBlog>myBlogOptional=myBlogService.findById(id);
        if (!myBlogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(myBlogOptional.get(),HttpStatus.OK);
    }
}
