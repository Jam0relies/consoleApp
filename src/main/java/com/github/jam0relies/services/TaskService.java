package com.github.jam0relies.services;
import com.github.jam0relies.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private TaskRowMapper taskRowMapper = new TaskRowMapper();

    //Класс, который нужен для отображения результатов выборки таблицы в Java объект
    private static class TaskRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Task task = new Task();

            task.setName(resultSet.getString("name"));
            task.setDescription(resultSet.getString("description"));
            task.setNotification(resultSet.getTimestamp("notification"));
            task.setContacts(resultSet.getString("contacts"));

            return task;
        }
    }

    public List<Task> getTasks() {
        String sql = "SELECT * FROM tasks";

        return jdbcTemplate.query(sql, taskRowMapper);
    }

    //Метод jdbcTemplate.update используется для вставки, удаления и обновления
    public void createTask(Task tasks) {
        String sql = "INSERT INTO tasks (name, description, notification, contacts) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, tasks.getName(), tasks.getDescription(), tasks.getNotification(), tasks.getContacts());
    }
}
