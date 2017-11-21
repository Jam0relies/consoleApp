import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost/tasktests";
        Properties props = new Properties();
        props.setProperty("user", "tasktester");
        props.setProperty("password", "123456");
        props.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(url, props);

//        String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
//        Connection conn = DriverManager.getConnection(url);

        PreparedStatement stat = connection.prepareStatement(
                "INSERT INTO tasks (name,text, date_time) VALUES " +
                        "(?, ?, ?)");
        stat.setString(1, "TaskName " + LocalDateTime.now().toString());
        stat.setString(2, "TaskText");
        stat.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        stat.execute();
    }
}
