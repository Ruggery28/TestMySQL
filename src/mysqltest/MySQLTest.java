/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mysqltest;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Ruggery
 */
public class MySQLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        searchUser();
    }

    //STUDYING ABOUT CRUD - CREATE, READ, UPDATE AND DELETE
    //READ
    public static void searchUser() {
        //TRY THE CONNECTION AND IF THERE IS SOMETHING WRONG CLOSE AND CATCH A ERROR MESSAGE
        try {

            //CREATING THE DRIVERS TO CONNECT TO MYSQL
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            //CREATING A CONNECTION WITH DRIVER FROM JAVA
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/list_task", "root", "Pass1234!");

            //CRETING A STATEMENT TO SEND TO DRIVE AND EXECUTE ON MYSQL
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM list_task.user");

            //STORING THE RESULT INSIDE THE RESULTSET
            ResultSet rs = stmt.executeQuery();

            //WHILE THERE IS A LINE TO READ WE STORE EVERY COLUMN INSIDE THE VALUES AND PRINT THEM AFTER
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");

                System.out.println("id: " + id);
                System.out.println("email: " + email);
                System.out.println("password: " + password);
                System.out.println(" ");
            }

            //WE NEED TO CLOSE THE STATEMENT AND CONNECTION, BECAUSE IT USE MEMORY
            stmt.close();
            c.close();

            //IF THERE IS NO RIGHT CONNECTION, IT CLOSE AND GIVE THE ERROR MESSAGE
        } catch (SQLException e) {
            System.out.println("Error when registering driver or connecting: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
