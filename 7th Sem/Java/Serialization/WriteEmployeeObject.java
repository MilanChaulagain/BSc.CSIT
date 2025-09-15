package Serialization;

import java.io.*;

// Employee class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Good practice for Serializable classes
    
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name       : " + name);
        System.out.println("Salary     : " + salary);
    }
}

public class WriteEmployeeObject {
    public static void main(String[] args) {
        // Create an employee object
        Employee emp = new Employee(101, "Milan", 55000.50);

        try {
            // Create file output stream to emp.doc
            FileOutputStream fos = new FileOutputStream("emp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Write object to file
            oos.writeObject(emp);

            System.out.println("Employee object written to emp.doc successfully!");

            // Close streams
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("Error writing object: " + e.getMessage());
        }
    }
}

