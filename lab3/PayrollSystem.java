import java.util.Scanner;
class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public double calculateBonus() {
        return 0.0; // Default implementation. It can be overridden in derived classes
    }

    public double calculateWeeklySalary() {
        return 0.0; // Default implementation. It can be overridden in derived classes
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
        System.out.println("Bonus: " + calculateBonus());
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return 0.05 * calculateWeeklySalary();
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public double calculateBonus() {
        return 0.1 * monthlySalary;
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (bonusPercentage / 100) * getMonthlySalary();
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        hourlyEmployee.setEmployeeId(57); // Employee Information ideally sourced from web server databases.
        hourlyEmployee.setEmployeeName("Shilpee Maitra");
        hourlyEmployee.setDesignation("PG Staff for MSAIM");
        try { // Data Validation achieved with the implementation of try-catch block
            System.out.print("Enter hourly rate: ");
            hourlyEmployee.setHourlyRate(scanner.nextDouble());
            System.out.print("Enter hours worked: ");
            hourlyEmployee.setHoursWorked(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid numeric value.");
            return;
        }
        hourlyEmployee.displayDetails();
    }
}
