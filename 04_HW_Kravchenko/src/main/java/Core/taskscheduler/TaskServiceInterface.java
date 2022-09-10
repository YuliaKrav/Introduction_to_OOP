package core.taskscheduler;

import java.util.List;

public interface TaskServiceInterface {
    void addTask(Task task);

    void deleteTask(Task task);

    void deleteTask(int id);

    Task getTaskOfId(int id);

    List<Task> getOnePriorityTasks(Priority priority);

    List<Task> getAllTasks();

    void loadFromOriginalFile();

    void saveToNewFile();

    void sortById();

    void sortByPriorityAndDate();

}
