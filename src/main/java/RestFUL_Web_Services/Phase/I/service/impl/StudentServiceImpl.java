package RestFUL_Web_Services.Phase.I.service.impl;

import RestFUL_Web_Services.Phase.I.entity.Course;
import RestFUL_Web_Services.Phase.I.entity.Student;
import RestFUL_Web_Services.Phase.I.repository.StudentRepo;
import RestFUL_Web_Services.Phase.I.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    public final StudentRepo studentRepo;


    @Override
    public void createStudent(Student student) {
        studentRepo.createStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findStudents();
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentRepo.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
