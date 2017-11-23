import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Authentication authentication = new Authentication("postgreslogin.xml");
        String url = authentication.getDatabaseURL();
        Properties props = new Properties();
        props.setProperty("user", authentication.getLogin());
        props.setProperty("password", authentication.getPassword());
        props.setProperty("ssl", "false");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Class.class.getClassLoader();
        }
        BufferedReader stream =
                new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("query.sql")));
        StringBuilder queryBuilder = new StringBuilder();
        while (stream.ready()) {
            queryBuilder.append(stream.readLine());
        }
        Connection connection = DriverManager.getConnection(url, props);
        Statement statement = connection.createStatement();
        statement.execute(queryBuilder.toString());

    }
}
