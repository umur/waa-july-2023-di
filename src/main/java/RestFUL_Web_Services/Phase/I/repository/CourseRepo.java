package RestFUL_Web_Services.Phase.I.repository;

import RestFUL_Web_Services.Phase.I.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public void updateCourse(Long id, Course course){
        Course courseToUpdate = courses.stream().filter(c -> Objects.equals(c.getId(), id)).findFirst().get();
        int index = courses.indexOf(courseToUpdate);
        if(index >-1){
            courses.set(index,course);
        } else {
            throw new RuntimeException("Course with id " + id + " doesn't exist");
        }
    }

    public void delete(Long id){
        Course courseToDelete = courses.stream().filter(c -> c.getId()==id).findFirst().get();
        courses.remove(courseToDelete);
    }
}
