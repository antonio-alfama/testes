package school.mindera.rest.classroom.model;

public class Classroom {

    private int id;
    private String name;
    private String location;

    public Classroom(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static ClassroomBuilder builder() {
        return new ClassroomBuilder();
    }

    public static class ClassroomBuilder {
        private int id;
        private String name;
        private String location;

        public ClassroomBuilder() {
        }

        public ClassroomBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ClassroomBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClassroomBuilder location(String location) {
            this.location = location;
            return this;
        }

        public Classroom build() {
            return new Classroom(id, name, location);
        }
    }
}
