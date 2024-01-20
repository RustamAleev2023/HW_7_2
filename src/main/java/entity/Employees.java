package entity;

import java.util.ArrayList;

public class Employees {
    ArrayList<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        employees.add(employee);
    }
    public void delete(Employee employee){
        employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void print(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
