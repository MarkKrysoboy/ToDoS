package ru.netology.javacore;

import java.util.*;

public class Todos {

    private String task;
    private String type;
    List setTasks = new ArrayList();

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addTask(String task) {
        setTasks.add(task);
    }

    public void removeTask(String task) {
        setTasks.remove(task);
    }

    public String getAllTasks() {
        Optional<String> reduced = setTasks.stream().sorted(Comparator.naturalOrder()).reduce((combinedValue, value) -> combinedValue + " " + value);
        return reduced.get();
    }
}

