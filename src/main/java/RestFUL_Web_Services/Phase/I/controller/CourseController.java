package RestFUL_Web_Services.Phase.I.controller;

import RestFUL_Web_Services.Phase.I.entity.Course;
import RestFUL_Web_Services.Phase.I.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/url")
    public RedirectView redirectView(){
        return new RedirectView("courses2.html");
    }

    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable Long id,@RequestBody Course course){
        courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.delete(id);
    }
}
