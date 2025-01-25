/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mysqltest;

import dao.UserDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
//DAO - DATA ACESS OBJECT
public class MySQLTest {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("==== INSERT USER ====");
        System.out.printf("Enter email: ");
        String email = scanner.nextLine();
        System.out.printf("Enter password: ");
        String password = scanner.nextLine();
        
        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        
        boolean insert = UserDAO.insertUser(u);
        
        if(insert){
            System.out.println("User inserted sucessfully!");
        } else{
            System.out.println("Error while trying to insert user.");
        } 

        
          
        /*
        System.out.println("==== SEARCH USER ====");

        ArrayList<User> users = UserDAO.searchUser();
        
        for (User u : users){
            System.out.println("["+ u.getId() + "]" + u.getEmail());
        }

          
        System.out.println("==== DELETE USER ====");
        //I created an Array inside the class User and instantiated the method searchUser inside the class UserDAO
        ArrayList<User> users = UserDAO.searchUser();

        //For every user inside the ArrayList users I will print its ID and Email
        for (User u : users) {
            System.out.println("[ " + u.getId() + " ]" + u.getEmail());
        }

        //I will ask to enter what Id they want to delete using the ID from the data base.
        System.out.printf("Enter the User ID you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //clean buffer

        //Creating a new Object u and then set the information the user entered inside the ID
        User u = new User();
        u.setId(id);

        //create a boolean variable to send the 'u' information to the method deleteuser
        boolean deleted = UserDAO.deleteUser(u);

        //if the variable is true, it means that the user was deleted, otherwise it didnt find and will give an error
        if (deleted) {
            System.out.println("User deleted sucessfully!");
        } else {
            System.out.println("Error trying to delete user!");
        }                   */
    }

}
