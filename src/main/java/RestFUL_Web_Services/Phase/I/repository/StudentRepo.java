package RestFUL_Web_Services.Phase.I.repository;

import RestFUL_Web_Services.Phase.I.entity.Course;
import RestFUL_Web_Services.Phase.I.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>();

    public void createStudent(Student student) {
        students.add(student);
    }

    public List<Student> findStudents() {
        return students;
    }

    public void updateStudent(Long id, Student student) {
        Student studentToUpdate = students.stream().filter(s -> Objects.equals(s.getId(), id)).findFirst().get();
        int index = students.indexOf(studentToUpdate);
        if (index > -1) {
            students.set(index, student);
        } else {
            throw new RuntimeException("Student with id " + id + " doesn't exist");
        }
    }

    public void deleteStudent(Long id) {
        Student studentToDelete = students.stream().filter(s -> Objects.equals(s.getId(), id)).findFirst().get();
        int index = students.indexOf(studentToDelete);
        if (index > -1) {
            students.remove(studentToDelete);
        } else {
            throw new RuntimeException("Student with id " + id + " doesn't exist");
        }
    }

    public List<Student> getStudentsByMajor(String major){
        List<Student> studentsByMajor = students.stream().filter(student -> {
            Course course = student.getCoursesTaken().stream().filter(c->c.getName() == major).findFirst().get();
            if(course != null) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());

        return studentsByMajor;
    }

    public List<Course> getCoursesByStudentId(int studentId){
        Student studentById = students.stream().filter(student -> student.getId() == studentId).findFirst().get();
        if(studentById != null){
            return studentById.getCoursesTaken();
        } else {
            throw new RuntimeException("Student with id " + studentId + " doesn't exist");
        }
    }
}
