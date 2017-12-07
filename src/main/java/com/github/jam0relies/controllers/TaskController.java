package com.github.jam0relies.controllers;

import com.github.jam0relies.models.Task;
import com.github.jam0relies.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    //path - урла, по которой будет делаться запрос
    //method - HTTP метод
    @RequestMapping(path = "/api/v1/frontend-api/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> students = taskService.getTasks();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //При помощи аннотации @RequestBody Spring автоматически из JSON переводит в JAVA объект Task
    @RequestMapping(path = "/api/v1/frontend-api/tasks", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskService.createTask(task);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/api/v1/frontend-api/tasks", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
    }
}
