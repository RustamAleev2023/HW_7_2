package entity;

import java.util.Map;

public class EmployeeWithPieceWorkPayment extends Employee{

    public EmployeeWithPieceWorkPayment(String name, String salaryType, String[] listOfCompletedWorks, Map<String, Integer> workPrice) {
        super(name, salaryType);
        this.salary = 0;
        for (String listOfCompletedWork : listOfCompletedWorks) {
            salary += workPrice.get(listOfCompletedWork);
        }
    }
}
