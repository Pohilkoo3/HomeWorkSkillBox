import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Oleg09061979$";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = getAveragePurchase(statement);
            printResultSet(resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ResultSet getAveragePurchase (Statement statement) throws SQLException {
        return statement.executeQuery("SELECT course_name, COUNT(*) as amount_purchase," +
                "COUNT(*)/MAX(MONTH(subscription_date)) as Average_purchase_per_Month, " +
                "COUNT(*)/(MAX(MONTH(subscription_date))-(MIN(MONTH(subscription_date))-1)) as Average_purchase_per_Month" +
                " FROM purchaselist GROUP BY(course_name)");
    }

    static void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            String print = resultSet.getString("course_name") + " → " +
                    (resultSet.getString("Average_purchase_per_Month").substring(0,4));
            System.out.println(print);
        }
    }

}
