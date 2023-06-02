package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Student;
import ra.repository.IStudentRepository;

import java.util.Optional;
@Service
public class StudentServiceIMPL implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return studentRepository.findStudentByName(name);
    }
}
