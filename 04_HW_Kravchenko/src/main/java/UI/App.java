package UI;

import core.taskscheduler.Priority;
import core.taskscheduler.TaskService;
import core.taskscheduler.TaskServiceInterface;

import java.util.Scanner;

public class App {
    public static void buttonClick() {
        TaskServiceInterface taskService = new TaskService();
        System.out.print("\033[H\033[J");
        System.out.println("Общий планировщик задач загружен...");
        taskService.loadFromOriginalFile();

        try (Scanner console = new Scanner(System.in)) {
            boolean isMainMenu = true;
            while (isMainMenu) {
                System.out.println();
                System.out.println("1 - Посмотреть все задачи\n2 - Отсортировать задачи по приоритету\n" +
                        "3 - Отсортировать задачи по идентификатору\n4 - Выбрать задачи с самым высоким уровнем приоритета\n" +
                        "5 - Удалить задачу по идентификатору\n6 - Записать задачи в файл json\n0 - Выход");
                String key = console.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "0" -> isMainMenu = false;
                    case "1" -> System.out.println("Список всех задач:" + taskService.getAllTasks());
                    case "2" -> {
                        taskService.sortByPriorityAndDate();
                        System.out.println("Задачи отсортированы по приоритету и дате. Нажмите 1 в меню, чтобы проверить..");
                    }
                    case "3" -> {
                        taskService.sortById();
                        System.out.println("Задачи отсортированы по идентификатору. Нажмите 1 в меню, чтобы проверить..");
                    }
                    case "4" ->
                            System.out.println("Задачи с приоритетом URGENT:\n" + taskService.getOnePriorityTasks(Priority.URGENT));
                    case "5" -> {
                        int oldTaskCounter = taskService.getAllTasks().size();
                        System.out.print("Введите идентификатор для удаления: ");
                        int id = console.nextInt();
                        taskService.deleteTask(id);
                        System.out.println(oldTaskCounter != taskService.getAllTasks().size() ? "Задача с номером " + id + " удалена." :
                                "Задачи с идентификатором " + id + " нет.");
                    }
                    case "6" -> {
                        taskService.saveToNewFile();
                        System.out.println("Актуальные задачи сохранены в файл.");
                    }
                    default -> System.out.println("Такого пункта меню нет");
                }
            }
        }
    }
}
