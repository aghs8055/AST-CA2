package education.models;

import java.util.List;

public class Course {
    public int courseId;
    public List<Integer> pre;

    public Course(int courseId, List<Integer> pre) {
        this.courseId = courseId;
        this.pre = pre;
    }
}
