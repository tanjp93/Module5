package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.MySong;
import ra.model.service.IMySongService;
import ra.model.service.MySongIMPL;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    IMySongService mySongService=new MySongIMPL();
    @Autowired
    @GetMapping("/")
    public ModelAndView toHome(){
        return new ModelAndView("index","mySongList",mySongService.findAll());
    }
    @GetMapping("/createNewSong")
    public String toCreateNewSong(Model model){
        model.addAttribute("newSong",new MySong());
        return "addNewSong";
    }
    @PostMapping("/addNewSong")
    public String toCreateNewSong(@RequestParam("pathSongInput") MultipartFile musicFile,@ModelAttribute("newSong")MySong mySong){
        System.out.println("my song ==>"+ mySong);
        String uploadPathProducts = "C:\\Users\\user\\Desktop\\Rikkei\\MD5\\02-demo\\Bai5_BT_TH\\BT_01\\uploadmusic\\src\\main\\resources\\assets\\music\\";
        //Upload IMG
        File file = new File(uploadPathProducts);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = musicFile.getOriginalFilename();
        if (fileName.length() == 0) {
//            fileName = productService.findById(updateProduct.getId()).getImg();
        }
        // coppy file upload đén thư mục chỉ đinh
        try {
            FileCopyUtils.copy(musicFile.getBytes(), new File(uploadPathProducts + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mySong.setPathSong(fileName);
        System.out.println(mySong);
        mySongService.save(mySong);
        return "redirect:/";
    }
}
