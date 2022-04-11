import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TreeSet;


public class DBConnection {

    private static Connection connection;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static int count = 0;
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
                    "PRIMARY KEY(id))");
                connection.createStatement().execute("DROP TABLE IF EXISTS workTime_station");
                connection.createStatement().execute("CREATE TABLE workTime_station(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "station INT NOT NULL, " +
                        "work_begin long NOT NULL, " +
                        "work_end long NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException{
       String sql = "INSERT INTO voter_count(name, birthDate, `count`) VALUES" + stringBuilder.toString();
        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void executeMultiInsertStationTimeWork() throws SQLException{
        StringBuilder stringBuilderStation = new StringBuilder();
        for (Integer votingStation : DocHandler.getVoteStationWorkTimes().keySet()) {
            WorkTime workTime = DocHandler.getVoteStationWorkTimes().get(votingStation);
            TreeSet<TimePeriod> listTimePeriods = workTime.getPeriods();
            for (TimePeriod timeperiod : listTimePeriods) {
                stringBuilderStation.append((stringBuilderStation.length() == 0 ? "" : ",") +
                        ("('" + votingStation + "', '" + timeperiod.getFrom() + "','" + timeperiod.getTo() + "')" ));
            }
        }
        String sql = "INSERT INTO workTime_station(station, work_begin, work_end) VALUES" + stringBuilderStation.toString();
        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        stringBuilder.append((stringBuilder.length() == 0 ? "" : ",") + ("('" + name + "', '" + birthDay + "', 1)" ));
        if (stringBuilder.length() > 3_000_000) {
            executeMultiInsert();
            count++;
            System.out.println(count * 81_000);
            stringBuilder = new StringBuilder();
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
