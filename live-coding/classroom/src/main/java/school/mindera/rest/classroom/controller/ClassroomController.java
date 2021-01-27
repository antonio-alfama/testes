package school.mindera.rest.classroom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import school.mindera.rest.classroom.model.Classroom;
import school.mindera.rest.classroom.service.ClassroomService;

import java.util.List;

@RestController
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classroom")
    public ResponseEntity<List<Classroom>> list() {
        List<Classroom> classrooms = classroomService.getClassroomList();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    // localhost:8080/classroom/create?name=batata&id=1&location=porto
    @GetMapping("/classroom/create")
    public ResponseEntity<Classroom> createWithQueryParams(@RequestParam String name, @RequestParam String location, @RequestParam int id) {
        Classroom classroom = classroomService.createClassroom(name, location, id);
        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @PostMapping("/classroom")
    public ResponseEntity<Classroom> createWithPost(@RequestBody Classroom classroom) {
        classroomService.createClassroom(classroom);
        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @DeleteMapping("/classroom/{index}")
    public ResponseEntity deleteByIndex(@PathVariable int index) {
        classroomService.deleteClassroom(index);
        return new ResponseEntity(HttpStatus.OK);
    }

}
