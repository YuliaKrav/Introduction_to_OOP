package core.filesworker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.taskscheduler.Priority;
import core.taskscheduler.Task;
import core.taskscheduler.TaskServiceInterface;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    TaskServiceInterface taskService;

    public FileService(TaskServiceInterface taskService) {
        this.taskService = taskService;
    }

//    public List<Task> readTasksfromFile(String path) {
//        try {
//            File file = new File(path);
//            //создаем объект FileReader для объекта File
//            FileReader fr = new FileReader(file);
//            //создаем BufferedReader с существующего FileReader для построчного считывания
//            BufferedReader reader = new BufferedReader(fr);
//            // считаем сначала первую строку
//            String line = reader.readLine();
//            while (line != null) {
//                List<String> stringParam = Arrays.stream(line.split(",")).toList();
//                Task task = new Task(parseStringToPriority(stringParam.get(0)), stringParam.get(1), parseStringToData(stringParam.get(2)));
//                taskService.addTask(task);
//                // считываем остальные строки в цикле
//                line = reader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void readTasksFromJsonFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        List<Task> tasksReadList = new ArrayList<>();

        try {
            // Reading from a file
            tasksReadList = mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Task task : tasksReadList) {
            taskService.addTask(task);
        }
        //System.out.println(tasksReadList);
    }

    public void writeTasksToJsonFile(String path) {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());

        try {
            // Writing to a file
            mapper.writeValue(new File(path), taskService.getAllTasks());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Priority parseStringToPriority(String priorityString) {
        return Priority.valueOf(priorityString);
    }

    private LocalDate parseStringToData(String dataString) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return LocalDateTime.parse(dataString, formatter);

        return LocalDate.parse(dataString);
    }
}
