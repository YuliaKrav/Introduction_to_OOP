package core.taskscheduler;

import java.time.LocalDate;

//Файл должен содержать следующие данные: id, дату добавления записи,
// время добавления записи, дедлай задачи, ФИО автора,
//        данные хранятся в файле csv/jsom/xml

public class Task {
    //private static int idCount = 0;

    private int id;
    private Priority priority;
    private String ownerName;
    private LocalDate dateDeadline;
    private LocalDate dateAdded;
    private String description;


    public Task() {
    }

    public Task(int id, Priority priority, String ownerName, LocalDate dateDeadline, LocalDate dateAdded, String description) {
        //idCount++;
        //this.id = idCount;
        this.id = id;
        this.priority = priority;
        this.ownerName = ownerName;
        this.dateDeadline = dateDeadline;
        this.dateAdded = LocalDate.now();
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDate getDateDeadline() {
        return dateDeadline;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\nid: " + id + "\npriority " + priority.toString().toLowerCase() + "\nowner " + ownerName +
                "\ndeadline " + dateDeadline + "\ndate added " + dateAdded;  /*+ "\ndescription " + description;*/
    }
}
