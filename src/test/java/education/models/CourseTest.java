package education.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    @Test
    public void testCourseWithOnePre() {
        Course course = new Course(1, List.of(2));
        assertEquals(1, course.courseId);
        assertEquals(1, course.pre.size());
        assertEquals(2, course.pre.get(0));
    }

    @Test
    public void testCourseWithoutPre() {
        Course course = new Course(1, List.of());
        assertEquals(1, course.courseId);
        assertEquals(0, course.pre.size());
    }

    @Test
    public void testCourseWithMultiplePre() {
        Course course = new Course(1, List.of(2, 3, 4));
        assertEquals(1, course.courseId);
        assertEquals(3, course.pre.size());
        assertEquals(2, course.pre.get(0));
        assertEquals(3, course.pre.get(1));
        assertEquals(4, course.pre.get(2));
    }
}
