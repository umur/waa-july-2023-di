package RestFUL_Web_Services.Phase.I.service;

import RestFUL_Web_Services.Phase.I.entity.Course;

import java.util.List;

public interface CourseService {
    void createCourse(Course course);
    List<Course> getCourses();

    void update(Long id, Course course);
    void delete(Long id);
}
