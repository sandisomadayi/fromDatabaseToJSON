import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import java.sql.*;

import java.util.HashMap;
import java.util.Map;

public class Work {
    final String GET_TABLE = "SELECT * FROM alarm";
    final String PUT_INTO_TABLE = "INSERT INTO alarm(message, ip, alarm_group, impact, host_ID, reinstates, alarm_ID) VALUES (?,?,?,?,?,?,?)";

    final String DB_LINK = "jdbc:h2:./target/create_db";

    FileWriter file;
    JSONObject jsonObject = new JSONObject();
    JSONArray jsonArray = new JSONArray();
    Map<String, String> map = new HashMap<String, String>();

    Connection connection;
    PreparedStatement getTAblePS;
    PreparedStatement putIntoTablePS;

    public Work() {
        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection(DB_LINK, "sandiso", "");

            getTAblePS = connection.prepareStatement(GET_TABLE);
            putIntoTablePS = connection.prepareStatement(PUT_INTO_TABLE);

            file = new FileWriter("./outputFile.json");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public void getTable() {
        try {
            ResultSet resultSet = getTAblePS.executeQuery();
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("message", resultSet.getString("message"));
                object.put("host_ip", resultSet.getString("ip"));
                object.put("alarm_group", resultSet.getString("alarm_group"));
                object.put("impact", resultSet.getString("impact"));
                object.put("host_id", resultSet.getString("host_ID"));
                object.put("reinstates", resultSet.getString("reinstates"));
                object.put("alarm_id", resultSet.getString("alarm_ID"));
                jsonArray.add(object);
            }
            jsonObject.put("values", jsonArray);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public void putData() {
        try {
//            INSERT INTO recordAlarm("messaging", "10.1.4.89", "group S", "impacting", 0, 4, 1534);
            putIntoTablePS.setString(1, "Messaging");
            putIntoTablePS.setString(2, "10.1.4.89");
            putIntoTablePS.setString(3, "group S");
            putIntoTablePS.setString(4, "impacting");
            putIntoTablePS.setString(5, "0");
            putIntoTablePS.setString(6, "4");
            putIntoTablePS.setString(7, "1534");
            putIntoTablePS.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Work work = new Work();
        work.putData();
        work.getTable();
        System.out.println(work.map);
    }
}