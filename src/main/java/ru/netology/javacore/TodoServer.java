package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private Todos todos;
    private int port;

    public TodoServer(int port, Todos todos) {
        this.todos = todos;
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                final String name = in.readLine();

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Task task = gson.fromJson(name, Task.class);

                switch (task.getType()) {
                    case ("ADD"):
                        todos.addTask(task);
                        break;
                    case ("REMOVE"):
                        todos.removeTask(task);
                        break;
                }
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
