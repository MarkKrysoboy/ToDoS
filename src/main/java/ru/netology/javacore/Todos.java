package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private Task task;
    List setTasks = new ArrayList();

    public void addTask(Task task) {
        setTasks.add(task);
    }

    public void removeTask(Task task) {
        setTasks.remove(task);
    }

    public String getAllTasks() {
        return setTasks.stream()
                .map(String::valueOf)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "))
                .toString();
    }
}

