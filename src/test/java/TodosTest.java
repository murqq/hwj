import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        SimpleTask task1 = new SimpleTask(1, "Groceries");
        SimpleTask task2 = new SimpleTask(2, "Cleaning");
        Meeting meeting1 = new Meeting(3, "Team Meeting", "Project A", "2023-06-13");
        Meeting meeting2 = new Meeting(4, "Client Meeting", "Project B", "2023-06-14");
        Epic epic1 = new Epic(5, new String[]{"Task 1", "Task 2", "Task 3"});
        Epic epic2 = new Epic(6, new String[]{"Task 4", "Task 5"});

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(epic1);
        todos.add(epic2);

        Task[] searchResult1 = todos.search("Groceries");
        assertArrayEquals(new Task[]{task1}, searchResult1);

        Task[] searchResult2 = todos.search("Cleaning");
        assertArrayEquals(new Task[]{task2}, searchResult2);

        Task[] searchResult3 = todos.search("Meeting");
        assertArrayEquals(new Task[]{meeting1, meeting2}, searchResult3);

        Task[] searchResult4 = todos.search("Task 3");
        assertArrayEquals(new Task[]{epic1}, searchResult4);

        Task[] searchResult5 = todos.search("Task");
        assertArrayEquals(new Task[]{epic1, epic2}, searchResult5);
    }

    @Test
    public void testSearch1() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Groceries");
        SimpleTask task2 = new SimpleTask(2, "Cleaning");
        Meeting meeting1 = new Meeting(3, "Team Meeting", "Project A", "2023-06-13");
        Meeting meeting2 = new Meeting(4, "Client Meeting", "Project B", "2023-06-14");
        Epic epic1 = new Epic(5, new String[]{"Task 1", "Task 2", "Task 3"});
        Epic epic2 = new Epic(6, new String[]{"Task 4", "Task 5"});

        todos.add(task1);
        todos.add(task2);
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(epic1);
        todos.add(epic2);

        Task[] searchResult1 = todos.search("Groceries");
        assertArrayEquals(new Task[]{task1}, searchResult1);

        Task[] searchResult2 = todos.search("Cleaning");
        assertArrayEquals(new Task[]{task2}, searchResult2);

        Task[] searchResult3 = todos.search("Meeting");
        assertArrayEquals(new Task[]{meeting1, meeting2}, searchResult3);

        Task[] searchResult4 = todos.search("Task 3");
        assertArrayEquals(new Task[]{epic1}, searchResult4);

        Task[] searchResult5 = todos.search("Task");
        assertArrayEquals(new Task[]{epic1, epic2}, searchResult5);

        Task[] searchResult6 = todos.search("Project A");
        assertArrayEquals(new Task[]{meeting1}, searchResult6);

        Task[] searchResult7 = todos.search("Project B");
        assertArrayEquals(new Task[]{meeting2}, searchResult7);
    }
}