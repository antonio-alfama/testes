package school.mindera.rest.classroom.service;

import org.springframework.stereotype.Service;
import school.mindera.rest.classroom.model.Classroom;
import school.mindera.rest.classroom.wrapper.ResultList;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClassroomService {

    private final ResultList<Classroom> classrooms = new ResultList<>();

    public List<Classroom> getClassroomList(Integer resultsPerPage, Integer page) {
        return classrooms.paginate(resultsPerPage, page);
    }

    public Classroom createClassroom(Classroom classroom) {
        classrooms.add(classroom);
        return classroom;
    }

    public Classroom createClassroom(String name, String location, int id) {
        Classroom classroom = Classroom.builder()
                .id(id)
                .name(name)
                .location(location)
                .build();
        return createClassroom(classroom);
    }

    public void deleteClassroom(int index) {
        classrooms.remove(index);
    }
}
