import entity.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Employees employees = new Employees();

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
        task6();

    }

    //Задание1
    //Разработать и протестировать набор классов для решения задачи подсчета зароботной платы сотрудников некоторой фирмы.
    //На фирме есть несколько способов оплаты труда:
    //■ ставка – указывается, сколько сотрудник получает за
    //рабочий день; для каждого сотрудника записывается,
    //сколько дней он отработал в месяце;
    //■ почасовая – указывается, сколько сотрудник получает в
    //час, для каждого сотрудника; записывается, сколько часов
    //он отработал в месяце
    //■ сдельная – указывается, сколько сотрудник получит за
    //выполненнуюработу; для каждогосотрудника записываются
    //суммы для каждой работы, что он успел сделать за месяц.
    public static void task1() {
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);


        System.out.println("ФИО\t\t\t" + "Вид оплаты\t\t\t" + "Сумма");
        employees.print();

    }

    //Задание 2
    //Для предыдущего задания вывести отчет с учетом налогов. Для сотрудников, которые на ставке и почасовой оплате
    //– налог 20%.
    //Для сотрудников со сдельной оплатой труда – 15%.
    public static void task2() {
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        int tax;
        System.out.println("ФИО\t\t\t" + "Налог, %\t" + "Сумма\t" + "К оплате");
        for (Employee employee : employees.getEmployees()) {
            if (employee.getSalaryType().equals("Сдельная")) {
                tax = 15;
            } else {
                tax = 20;
            }
            System.out.println(employee.getName() + "\t" + tax + "\t\t\t" + employee.getSalary() + "\t\t" + (employee.getSalary() - (employee.getSalary() * tax / 100)));
        }
    }

    //Задание 3
    //На основе предыдущего задания сделать новый отчет
    //таким образом, что для сотрудников, у которых нет детей,
    //ставка налога выше на 5%.
    public static void task3() {
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employee1.setHasChildren(false);
        employee2.setHasChildren(false);
        employee3.setHasChildren(true);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        int tax;
        int taxSurcharge = 0; //+5% к налогам у кого нет детей
        System.out.println("ФИО\t\t\t" + "Налог, %\t" + "Сумма(руб)\t" + "К оплате");
        for (Employee employee : employees.getEmployees()) {
            if (!employee.isHasChildren()) {
                taxSurcharge = 5;
            } else {
                taxSurcharge = 0;
            }
            if (employee.getSalaryType().equals("Сдельная")) {
                tax = 15 + taxSurcharge;
            } else {
                tax = 20 + taxSurcharge;
            }
            System.out.println(employee.getName() + "\t" + tax + "\t\t\t" + employee.getSalary() + "\t\t\t" + (employee.getSalary() - (employee.getSalary() * tax / 100)));
        }
    }

    //Задание 4
    //На основе предыдущего задания переделать отчет, с учетом того, что сотрудники с почасовой оплатой, половину
    //зарплаты получают в валюте (тугриках), по курсу на день
    //начисления заработной платы
    public static void task4(){
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employee1.setHasChildren(false);
        employee2.setHasChildren(false);
        employee3.setHasChildren(true);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        int tax;
        int taxSurcharge = 0;
        int currencyRate = 8;
        int forPayment;
        System.out.println("ФИО\t\t\t" + "Налог, %\t" + "Сумма(руб)\t" + "К оплате(руб/тугрики) Курс 1/8");
        for (Employee employee : employees.getEmployees()) {
            if (!employee.isHasChildren()) {
                taxSurcharge = 5;
            } else {
                taxSurcharge = 0;
            }
            if (employee.getSalaryType().equals("Сдельная")) {
                tax = 15 + taxSurcharge;
            } else {
                tax = 20 + taxSurcharge;
            }
            if(employee.getSalaryType().equals("Почасовая")){
                forPayment = (employee.getSalary() - (employee.getSalary() * tax / 100)) / currencyRate;
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t"
                        + employee.getSalary() + "\t\t\t"
                        + (employee.getSalary() - (employee.getSalary() * tax / 100)) + "/" + forPayment);
            } else {
                forPayment = (employee.getSalary() - (employee.getSalary() * tax / 100));
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t" + employee.getSalary() + "\t\t\t" + forPayment);
            }
        }
    }

    //Задание 5
    //Фирма переводит часть сотрудников в офшорную зону.
    //Сотрудники, находящиеся в офшоре, не платят налогов. Создать новый отчет с учетом данного нововведения.
    public static void task5(){
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employee1.setHasChildren(false);
        employee2.setHasChildren(false);
        employee3.setHasChildren(true);
        employee1.setOffshore(true);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        int tax;
        int taxSurcharge = 0;
        int currencyRate = 8;
        int forPayment;
        System.out.println("ФИО\t\t\t" + "Налог, %\t" + "Сумма(руб)\t" + "К оплате(руб/тугрики) Курс 1/8");
        for (Employee employee : employees.getEmployees()) {
            if (!employee.isHasChildren()) {
                taxSurcharge = 5;
            } else {
                taxSurcharge = 0;
            }
            if (employee.getSalaryType().equals("Сдельная")) {
                tax = 15 + taxSurcharge;
            } else {
                tax = 20 + taxSurcharge;
            }
            if(employee.isOffshore()){
                tax = 0;
            }
            if(employee.getSalaryType().equals("Почасовая")){
                forPayment = (employee.getSalary() - (employee.getSalary() * tax / 100)) / currencyRate;
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t"
                        + employee.getSalary() + "\t\t\t"
                        + (employee.getSalary() - (employee.getSalary() * tax / 100)) + "/" + forPayment);
            } else {
                forPayment = (employee.getSalary() - (employee.getSalary() * tax / 100));
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t" + employee.getSalary() + "\t\t\t" + forPayment);
            }
        }
    }

    //Задание 6
    //Фирма вводит премии сотрудникам, которые работали
    //больше 200 часов в месяц, но не находятся в офшоре. Премии должны суммироваться в основную зарплату. Создать
    //новый отчет с учетом изменений.
    public static void task6(){
        Employee employee1 = new EmployeeWithFixedPayment("Employee1", "Ставка\t", 100, 30);
        Employee employee2 = new EmployeeWithHourlyPayment("Employee2", "Почасовая", 12, 100);
        String[] listOfCompletedWorks = {"work1", "work1", "work2"};
        Map<String, Integer> workPrice = new HashMap<>();
        workPrice.put("work1", 100);
        workPrice.put("work2", 200);
        Employee employee3 = new EmployeeWithPieceWorkPayment("Employee3", "Сдельная", listOfCompletedWorks, workPrice);
        employee1.setHasChildren(false);
        employee2.setHasChildren(false);
        employee3.setHasChildren(true);
        employee1.setOffshore(false);
        employee2.setOffshore(false);
        employee3.setOffshore(false);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        int tax;
        int taxSurcharge = 0;
        int currencyRate = 8;
        int forPayment;
        int bonus = 0; //бонус 20% для отработавших в месяц более 200часов

        System.out.println("ФИО\t\t\t" + "Налог, %\t" + "Сумма(руб)\t" + "К оплате(руб/тугрики) Курс 1/8");
        for (Employee employee : employees.getEmployees()) {
            int salary = employee.getSalary(); //ЗП до вычета налогов

            if (!employee.isHasChildren()) {
                taxSurcharge = 5;
            } else {
                taxSurcharge = 0;
            }
            if (employee.getSalaryType().equals("Сдельная")) {
                tax = 15 + taxSurcharge;
            } else {
                tax = 20 + taxSurcharge;
            }
            if(employee.isOffshore()){
                tax = 0;
            }
            if(!employee.isOffshore()){
                bonus = employee.getSalary() + employee.getSalary() * 20 / 100;
            }

            if(employee.getSalaryType().equals("Почасовая")){
                forPayment = ((salary+bonus) - ((salary+bonus) * tax / 100)) / currencyRate;
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t"
                        + (salary + bonus) + "\t\t\t"
                        + ((salary + bonus) - ((salary + bonus) * tax / 100)) + "/" + forPayment);
            } else {
                forPayment = ((salary+bonus) - ((salary+bonus) * tax / 100));
                System.out.println(employee.getName() + "\t" + tax + "\t\t\t" + (employee.getSalary()+bonus) + "\t\t\t" + forPayment);
            }
            System.out.println(!employee.isOffshore() + " " + bonus);

        }
    }
}
