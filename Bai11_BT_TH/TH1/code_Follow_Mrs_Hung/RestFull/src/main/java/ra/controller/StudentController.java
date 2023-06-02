package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.Student;
import ra.service.IStudentService;

import java.util.List;
import java.util.Optional;

@RestController //requestBody + controller
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student>list= (List<Student>) studentService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student>findById(@PathVariable("id")Long id){
        Optional<Student> studentOptional=studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        }
    }
    @GetMapping("/findStudentByName")
    public ResponseEntity<List<Student>>findStudentByName(@RequestParam("name")String name){
        List<Student>list= (List<Student>) studentService.findByName(name);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return  new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Student>update(@PathVariable("id")Long id,Student student){
        Optional<Student> studentOptional=studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(id);
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if(studentOptional.isPresent()){
            studentService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
