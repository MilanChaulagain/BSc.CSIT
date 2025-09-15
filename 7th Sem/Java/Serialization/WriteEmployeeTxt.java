package Serialization;

import java.io.*;

// Employee class (no need for Serializable here)
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Convert to string for writing in text form
    @Override
    public String toString() {
        return "Employee ID: " + id + "\n"
             + "Name       : " + name + "\n"
             + "Salary     : " + salary + "\n";
    }
}

public class WriteEmployeeTxt {
    public static void main(String[] args) {
        // Create an employee object
        Employee emp = new Employee(101, "Milan", 55000.50);

        try {
            // Write in text form
            FileWriter fw = new FileWriter("emp.doc");
            BufferedWriter bw = new BufferedWriter(fw);

            // Writing Employee data as plain text
            bw.write(emp.toString());

            System.out.println("Employee details written to emp.doc in text format.");

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing employee data: " + e.getMessage());
        }
    }
}

