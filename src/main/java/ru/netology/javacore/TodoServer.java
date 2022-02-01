package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    Todos todos;
    int port;

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

                String type = gson.fromJson(name, Todos.class).getType();
                String task = gson.fromJson(name, Todos.class).getTask();

                if (type.equals("ADD")) {
                    todos.addTask(task);
                } else if (type.equals("REMOVE")) {
                    todos.removeTask(task);
                }
                out.println(todos.getAllTasks());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
