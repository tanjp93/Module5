package ra.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.Student;

import java.util.Optional;

@Repository
public interface IStudentRepository extends PagingAndSortingRepository<Student,Long>{
    Iterable<Student>findStudentByAge(int age);
    @Query("select s from Student  as s where s.studentName like concat('%',:name,'%') ")
    Iterable<Student> findStudentByName(@Param("name")String name);
}
