package ru.netology.javacore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos;

    @BeforeEach
    public void startTest() {
        todos = new Todos();
    }

    @AfterEach
    public void stopTest() {
        System.out.println("Test finished");
        todos = null;
    }

    @Test
    public void testAddTasksCount() {
        //arrange
        todos.addTask(new Task("Первая"));
        todos.addTask(new Task("Вторая"));
        todos.addTask(new Task("Третья"));
        long expected = 3;
        //act
        long result = todos.setTasks.size();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAddTasksGoal() {
        //arrange
        todos.addTask(new Task("Прогулка"));
        todos.addTask(new Task("Бег"));
        todos.addTask(new Task("Секция"));
        //act
        Boolean result = todos.setTasks.contains(new Task("Бег"));
        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testRemoveTasksCount() {
        //arrange
        todos.addTask(new Task("Прогулка"));
        todos.addTask(new Task("Бег"));
        todos.addTask(new Task("Секция"));
        todos.removeTask(new Task("Бег"));
        long expected = 2;
        //act
        long result = todos.setTasks.size();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRemoveTasksGoal() {
        //arrange
        todos.addTask(new Task("Прогулка"));
        todos.addTask(new Task("Бег"));
        todos.addTask(new Task("Секция"));
        todos.removeTask(new Task("Бег"));
        //act
        Boolean result = todos.setTasks.contains(new Task("Бег"));
        //assert
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testGetAllTasks() {
        //arrange
        todos.addTask(new Task("Прогулка"));
        todos.addTask(new Task("Секция"));
        todos.addTask(new Task("Бег"));
        String expected = "Бег Прогулка Секция";
        //act
        String result = todos.getAllTasks();
        //assert
        Assertions.assertEquals(expected, result);
    }
}
