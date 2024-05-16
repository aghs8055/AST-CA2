package education.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecordTest {
    @Test
    public void testRecord() {
        Record record = new Record(1, 2, 15.3, true);
        assertEquals(1, record.termId);
        assertEquals(2, record.courseId);
        assertEquals(15.3, record.grade);
        assertTrue(record.isMehman);
    }
}
