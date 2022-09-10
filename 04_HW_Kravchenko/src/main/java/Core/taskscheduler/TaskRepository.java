package core.taskscheduler;

import java.util.*;

public class TaskRepository {
    List<Task> taskList;

    public TaskRepository() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    public void removeTask(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                removeTask(task);
                break;
            }
        }
    }

    public Task getTaskOfId(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public List<Task> getOnePriorityTasks(Priority priority) {
        List<Task> resultTaskList = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getPriority() == priority) {
                resultTaskList.add(task);
            }
        }
        return resultTaskList;
    }

    public void sortTasksById() {
        Collections.sort(taskList, Comparator.comparing(Task::getId));
        System.out.println(taskList);
    }

    public void sortTasksByPriorityAndDate() {
        Collections.sort(taskList, (o1, o2) -> {
                    if (o1.getPriority() == o2.getPriority()) {
                        return o1.getDateDeadline().compareTo(o2.getDateDeadline());
                    }
                    return o1.getPriority().compareTo(o2.getPriority());
                }
        );
        System.out.println(taskList);
    }

}
