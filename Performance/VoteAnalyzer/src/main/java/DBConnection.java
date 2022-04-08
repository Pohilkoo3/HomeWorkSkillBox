import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {

    private static Connection connection;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "Oleg09061979$";
    private static StringBuilder stringBuilder = new StringBuilder();
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id)," +           //  )");
                    "UNIQUE KEY name_date(name(50), birthDate))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException{
       String sql = "INSERT INTO voter_count(name, birthDate, `count`) VALUES" + stringBuilder.toString();
//        String sql = "INSERT INTO voter_count(name, birthDate, `count`) VALUES" + stringBuilder.toString()
//                +  " ON DUPLICATE KEY UPDATE count=count+1";
        DBConnection.getConnection().createStatement().execute(sql);
    }
    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        stringBuilder.append((stringBuilder.length() == 0 ? "" : ",") + ("('" + name + "', '" + birthDay + "', 1)" ));
        if (stringBuilder.length() > 3_000_000) {
            executeMultiInsert();
            System.out.println("Выполнил вставку==================================================");
            stringBuilder = new StringBuilder();
        }
    }




    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }

    public static void saveResultsMeasure (long timeProcess, String terms) throws SQLException{
        if (connection == null) {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
        }
        connection.createStatement().execute("CREATE TABLE IF NOT EXISTS results_measures(" +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "terms MEDIUMTEXT NOT NULL, " +
                "timeProcess_ms long NOT NULL, " +
                "timeProcess_s double NOT NULL, " +
                "PRIMARY KEY(id))");
            double resultS = timeProcess/1000;
            String sql = "INSERT INTO results_measures(terms, timeProcess_ms, timeProcess_s)" +
                    " VALUES('" + terms +"', " + timeProcess + ", " + resultS +")";
            connection.createStatement().execute(sql);
            connection.close();

        }



}
