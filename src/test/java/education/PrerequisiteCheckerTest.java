package education;

import static org.junit.jupiter.api.Assertions.*;

import education.models.Course;
import education.models.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrerequisiteCheckerTest {
    private List<Record> records;

    @BeforeEach
    public void setUp() {
        records = List.of(
                new Record(1, 1, 9, true),
                new Record(2, 2, 10, true),
                new Record(3, 3, 12, true),
                new Record(4, 2, 12, true),
                new Record(5, 4, 9, false),
                new Record(6, 5, 10, false),
                new Record(7, 4, 13, false),
                new Record(8, 6, 9.9, false)
        );
    }

    @Test
    public void testCourseWithoutPrerequisites() {
        Course course = new Course(1, List.of());

        assertTrue(PrerequisiteChecker.hasPassedPre(List.of(), course));
    }

    @Test
    public void testCourseWithOneFailedMehmanPrerequisite() {
        Course course = new Course(1, List.of(1));

        assertFalse(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithOnePassedMehmanPrerequisite() {
        Course course = new Course(1, List.of(3));

        assertTrue(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithOnePassedAfterFailedMehmanPrerequisite() {
        Course course = new Course(1, List.of(2));

        assertTrue(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithOnePassedAfterFailedNonMehmanPrerequisite() {
        Course course = new Course(1, List.of(4));

        assertTrue(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithOnePassedNonMehmanPrerequisite() {
        Course course = new Course(1, List.of(5));

        assertTrue(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithOneFailedNonMehmanPrerequisite() {
        Course course = new Course(1, List.of(6));

        assertFalse(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithMultiplePrerequisitesFalse() {
        Course course = new Course(1, List.of(1, 2, 3));

        assertFalse(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithMultiplePrerequisitesTrue() {
        Course course = new Course(1, List.of(2, 3, 4));

        assertTrue(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithNoTakenPrerequisites() {
        Course course = new Course(1, List.of(7));

        assertFalse(PrerequisiteChecker.hasPassedPre(records, course));
    }

    @Test
    public void testCourseWithoutRecords() {
        Course course = new Course(1, List.of(1));

        assertFalse(PrerequisiteChecker.hasPassedPre(List.of(), course));
    }
}
