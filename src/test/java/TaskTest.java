import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Buy groceries");
        assertTrue(task.matches("groceries"));
        assertFalse(task.matches("shopping"));
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Implement feature A", "Write unit tests", "Update documentation"};
        Epic epic = new Epic(2, subtasks);
        assertTrue(epic.matches("unit tests"));
        assertFalse(epic.matches("bug fixes"));
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(3, "Project kickoff", "Project X", "2023-06-15 10:00");
        assertTrue(meeting.matches("kickoff"));
        assertTrue(meeting.matches("Project X"));
        assertFalse(meeting.matches("meeting room"));
    }
}
