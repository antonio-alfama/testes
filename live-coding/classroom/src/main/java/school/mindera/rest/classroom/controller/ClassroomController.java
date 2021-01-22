package school.mindera.rest.classroom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import school.mindera.rest.classroom.model.Classroom;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ClassroomController {

    private static final List<Classroom> classrooms = new LinkedList<>();

    @GetMapping("/classroom")
    public ResponseEntity<List<Classroom>> list() {
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }

    // localhost:8080/classroom/create?name=batata&id=1&location=porto
    @GetMapping("/classroom/create")
    public ResponseEntity<Classroom> createWithQueryParams(@RequestParam String name, @RequestParam String location, @RequestParam int id) {
        Classroom classroom = new Classroom();

        classroom.setId(id);
        classroom.setName(name);
        classroom.setLocation(location);

        classrooms.add(classroom);

        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @PostMapping("/classroom")
    public ResponseEntity<Classroom> createWithPost(@RequestBody Classroom classroom) {
        classrooms.add(classroom);

        return new ResponseEntity<>(classroom, HttpStatus.CREATED);
    }

    @DeleteMapping("/classroom/{index}")
    public ResponseEntity deleteByIndex(@PathVariable int index) {
        classrooms.remove(index);

        //classroomService.remove(index);

        return new ResponseEntity(HttpStatus.OK);
    }

}
