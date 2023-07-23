package RestFUL_Web_Services.Phase.I.service;

import RestFUL_Web_Services.Phase.I.entity.Course;
import RestFUL_Web_Services.Phase.I.entity.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);

    List<Student> getStudents();

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
