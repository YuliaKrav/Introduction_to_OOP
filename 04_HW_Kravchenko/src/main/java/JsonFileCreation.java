import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import core.taskscheduler.Priority;
import core.taskscheduler.Task;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class JsonFileCreation { //не участвует в основной работе, использовался для создания файла с задачами
    public static void main(String[] args) {

        List<Task> tasksList = new ArrayList<>();
        tasksList.add(new Task(1, Priority.HIGH, "Petr", LocalDate.now().plusDays(5), LocalDate.now().minusDays(4), "Description1"));
        tasksList.add(new Task(2, Priority.HIGH, "Vera", LocalDate.now().plusDays(4), LocalDate.now().minusDays(3), "Description2"));
        tasksList.add(new Task(3, Priority.URGENT, "Petr", LocalDate.now().plusDays(1), LocalDate.now().minusDays(100), "Description3"));
        tasksList.add(new Task(4, Priority.LOW, "Petr", LocalDate.now().plusDays(10), LocalDate.now().minusDays(10), "Description4"));
        tasksList.add(new Task(5, Priority.URGENT, "Vera", LocalDate.now().plusDays(3), LocalDate.now().minusDays(11), "Description5"));
        tasksList.add(new Task(6, Priority.LOW, "Petr", LocalDate.now().plusDays(50), LocalDate.now().minusDays(10), "Description6"));
        tasksList.add(new Task(7, Priority.MEDIUM, "Vera", LocalDate.now().plusDays(7), LocalDate.now().minusDays(20), "Description7"));
        tasksList.add(new Task(8, Priority.URGENT, "Petr", LocalDate.now().plusDays(2), LocalDate.now().minusDays(7), "Description8"));
        System.out.println(tasksList);

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());

        try {
            mapper.writeValue(new File("file.json"), tasksList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Task> tasksReadList = new ArrayList<>();
        try {
            tasksReadList = mapper.readValue(new File("file.json"), mapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(tasksReadList);
    }
}
