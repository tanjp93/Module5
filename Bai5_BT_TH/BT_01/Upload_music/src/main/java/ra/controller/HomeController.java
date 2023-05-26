package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    @GetMapping("/")
    public String toHome(){
        return "index";
    }
    @GetMapping("/createNewSong")
    public String toCreateNewSong(Model model){
        model.addAttribute("newSong",new FileUp)
        return "addNewSong";
    }

    public HomeController() {
    }

    @PostMapping("/addNewSong")
    public String toCreateNewSong(@RequestParam("fileNameInput")MultipartFile musicFile,@RequestParam("fileNameInput")MultipartFile imgFile){
        String uploadPathProducts = "C:\\Users\\user\\Desktop\\Rikkei\\MD5\\02-demo\\Bai5_BT_TH\\BT_01\\Upload_music\\src\\main\\resources\\assets\\music\\";
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
//        updateProduct.setImg(fileName);
        //Update file
//        productService.update(updateProduct);
        return "redirect:/";
    }
}
