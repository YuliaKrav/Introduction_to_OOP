package core.taskscheduler;

import core.filesworker.FileService;

import java.util.*;

public class TaskService implements TaskServiceInterface {
    private TaskRepository taskRepository;
    private FileService fileService;
    private String pathGeneral = "src\\main\\java\\core\\files\\";
    private String nameFileJson = "tasksOriginal.json";
    private String newNameFileJson = "tasksNew.json";

    public TaskService() {
        this.taskRepository = new TaskRepository();
        fileService = new FileService(this);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.removeTask(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.removeTask(id);
    }

    @Override
    public Task getTaskOfId(int id) {
        return taskRepository.getTaskOfId(id);
    }

    @Override
    public List<Task> getOnePriorityTasks(Priority priority) {
        return taskRepository.getOnePriorityTasks(priority);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getTaskList();
    }

    @Override
    public void loadFromOriginalFile() {
        fileService.readTasksFromJsonFile(pathGeneral + nameFileJson);
    }

    @Override
    public void saveToNewFile() {
        fileService.writeTasksToJsonFile(pathGeneral + newNameFileJson);
    }

    @Override
    public void sortById() {
        taskRepository.sortTasksById();
    }

    @Override
    public void sortByPriorityAndDate() {
        taskRepository.sortTasksByPriorityAndDate();
    }
}


