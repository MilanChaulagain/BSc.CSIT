package FileHandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + salary;
    }
}

public class EmployeeFileWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter writer = null;

        try {
            writer = new FileWriter("employee.doc", true); // Append mode

            System.out.print("Enter number of employees: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Employee " + (i + 1) + ":");

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Salary: ");
                double salary = Double.parseDouble(sc.nextLine());

                Employee emp = new Employee(id, name, salary);

                // Write to file
                writer.write(emp.toString() + "\n");
            }

            System.out.println("\nEmployee data successfully written to emp.doc");

        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                sc.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}

