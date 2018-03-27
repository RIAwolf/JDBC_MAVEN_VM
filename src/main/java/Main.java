

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.100.100:3306/kcs", "root", "root");
            Statement st = connection.createStatement();
            ResultSet set = st.executeQuery("SELECT * FROM `students`;");
            printTable(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printTable(ResultSet set) {
        try {
            ResultSetMetaData aprasymas = set.getMetaData();
            while (set.next()) {
                int stulpeliuSkaicius = aprasymas.getColumnCount();
                for (int i = 1; i <= stulpeliuSkaicius; i++) {
                    System.out.print(set.getString(i) + "\t");
                }
                System.out.println();


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
