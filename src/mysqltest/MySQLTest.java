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
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
public class MySQLTest {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==== USERS REGISTERED ====");
        System.out.println("");
        searchUser();
        
        System.out.println("");
        System.out.println("==== INSERT USERS ====");
        System.out.println("");
        insertUser();
        
        System.out.println("");
        System.out.println("==== UPDATE USER ====");
        System.out.println("");
        updateUser();
        
        System.out.println("");
        System.out.println("==== DELETE USER ====");
        System.out.println("");
        deleteUser();
        
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

    //CREATE
    public static void insertUser() {

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {

            //CREATING THE DRIVERS TO CONNECT TO MYSQL
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            //CREATING A CONNECTION WITH DRIVER FROM JAVA
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/list_task", "root", "Pass1234!");

            //CRETING A STATEMENT TO SEND TO DRIVE AND EXECUTE ON MYSQL, ? will be the value we will switch
            PreparedStatement stmt = c.prepareStatement("INSERT INTO list_task.user (email, password) VALUES (?, ?)");

            //SETTING THE VALUES INSIDE THE '?' WITH STMT
            stmt.setString(1, email);
            stmt.setString(2, password);

            //STORE INSIDE THE IN ROWSAFFECTED THE UPDATE THAT WAS MADE INSIDE THE STMT
            int rowsAffected = stmt.executeUpdate();

            //CHECK IF THE UPDATE WAS SUCESSFULLY BY CHEKING HOW MANY ROWS WAS AFFECTED INSIDE MYSQL
            if (rowsAffected > 0) {
                System.out.println("User inserted sucessfully!");
            } else {
                System.out.println("Error, Try it again.");
            }

        } catch (SQLException e) {
            System.out.println("Error when registering driver or connecting: " + e.getMessage());
            e.printStackTrace();
        }

    }

    
    //UPDATE
    public static void updateUser(){
        
        searchUser();
        System.out.printf("Enter the id you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //cleaning buffer
        
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        
        try {

            //CREATING THE DRIVERS TO CONNECT TO MYSQL
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            //CREATING A CONNECTION WITH DRIVER FROM JAVA
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/list_task", "root", "Pass1234!");

            //CRETING A STATEMENT TO SEND TO DRIVE AND EXECUTE ON MYSQL, ? will be the value we will switch
            PreparedStatement stmt = c.prepareStatement("UPDATE list_task.user SET email = ?, password = ? WHERE id = ?");

            //SETTING THE VALUES INSIDE THE '?' WITH STMT
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setInt(3, id);

            //STORE INSIDE THE IN ROWSAFFECTED THE UPDATE THAT WAS MADE INSIDE THE STMT
            int rowsAffected = stmt.executeUpdate();

            //CHECK IF THE UPDATE WAS SUCESSFULLY BY CHEKING HOW MANY ROWS WAS AFFECTED INSIDE MYSQL
            if (rowsAffected > 0) {
                System.out.println("User inserted sucessfully!");
            } else {
                System.out.println("Error, Try it again.");
            }

        } catch (SQLException e) {
            System.out.println("Error when registering driver or connecting: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
    
    
    public static void deleteUser(){
        
        searchUser();
        System.out.printf("Enter the ID you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //cleaning buffer
        
        try {

            //CREATING THE DRIVERS TO CONNECT TO MYSQL
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            //CREATING A CONNECTION WITH DRIVER FROM JAVA
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/list_task", "root", "Pass1234!");

            //CRETING A STATEMENT TO SEND TO DRIVE AND EXECUTE ON MYSQL, ? will be the value we will switch
            PreparedStatement stmt = c.prepareStatement("DELETE FROM list_task.user WHERE id = ?");

            //SETTING THE VALUES INSIDE THE '?' WITH STMT
            stmt.setInt(1, id);

            //STORE INSIDE THE IN ROWSAFFECTED THE UPDATE THAT WAS MADE INSIDE THE STMT
            int rowsAffected = stmt.executeUpdate();

            //CHECK IF THE UPDATE WAS SUCESSFULLY BY CHEKING HOW MANY ROWS WAS AFFECTED INSIDE MYSQL
            if (rowsAffected > 0) {
                System.out.println("User inserted sucessfully!");
            } else {
                System.out.println("Error, Try it again.");
            }

        } catch (SQLException e) {
            System.out.println("Error when registering driver or connecting: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
    
}
