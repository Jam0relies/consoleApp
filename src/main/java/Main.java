import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Authentication authentication = new Authentication("postgreslogin.xml");
        String url = authentication.getDatabaseURL();
        Properties props = new Properties();
        props.setProperty("user", authentication.getLogin());
        props.setProperty("password", authentication.getPassword());
        props.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(url, props);

        PreparedStatement stat = connection.prepareStatement(
                "INSERT INTO tasks (name,text, date_time) VALUES " +
                        "(?, ?, ?)");
        stat.setString(1, "TaskName " + LocalDateTime.now().toString());
        stat.setString(2, "TaskText");
        stat.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        stat.execute();
    }
}
