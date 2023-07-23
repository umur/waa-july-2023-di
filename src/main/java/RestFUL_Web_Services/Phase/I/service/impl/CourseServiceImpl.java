package RestFUL_Web_Services.Phase.I.service.impl;

import RestFUL_Web_Services.Phase.I.entity.Course;
import RestFUL_Web_Services.Phase.I.repository.CourseRepo;
import RestFUL_Web_Services.Phase.I.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    public final CourseRepo courseRepo;

    @Override
    public void createCourse(Course course) {
        courseRepo.addCourse(course);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.getCourses();
    }

    @Override
    public void update(Long id, Course course) {
        courseRepo.updateCourse(id,course);
    }

    @Override
    public void delete(Long id) {
        courseRepo.delete(id);
    }
}
