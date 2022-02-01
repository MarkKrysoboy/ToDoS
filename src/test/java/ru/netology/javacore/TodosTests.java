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
        todos.addTask("Первая");
        todos.addTask("Вторая");
        todos.addTask("Третья");
        long expected = 3;
        //act
        long result = todos.setTasks.size();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAddTasksGoal() {
        //arrange
        todos.addTask("Прогулка");
        todos.addTask("Бег");
        todos.addTask("Секция");
        //act
        Boolean result = todos.setTasks.contains("Бег");
        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void testRemoveTasksCount() {
        //arrange
        todos.addTask("Прогулка");
        todos.addTask("Бег");
        todos.addTask("Секция");
        todos.removeTask("Бег");
        long expected = 2;
        //act
        long result = todos.setTasks.size();
        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRemoveTasksGoal() {
        //arrange
        todos.addTask("Прогулка");
        todos.addTask("Бег");
        todos.addTask("Секция");
        todos.removeTask("Бег");
        //act
        Boolean result = todos.setTasks.contains("Бег");
        //assert
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testGetAllTasks() {
        //arrange
        todos.addTask("Прогулка");
        todos.addTask("Секция");
        todos.addTask("Бег");
        String expected = "Бег Прогулка Секция";
        //act
        String result = todos.getAllTasks();
        //assert
        Assertions.assertEquals(expected, result);
    }
}
