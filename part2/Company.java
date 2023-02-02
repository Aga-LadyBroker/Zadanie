package pl.ladybroker.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {

    private ArrayList<Employee> employees = new ArrayList<>();
    private final Logger logger;

    public Company(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    private boolean employeeExists(Employee employee) {
        boolean exists = false;
        for (Employee tmpEmployee : employees) {
            if (tmpEmployee.isEqual(employee)) {
                return true;
            }
        }
        return false;
    }

    public void add(Employee newEmployee) {
        if (!employeeExists(newEmployee)) {
            employees.add(newEmployee);
            logger.info("Pracownik dodany (" + newEmployee.toString() + ")");
        } else {
            logger.error("Próba dodania pracownika o tych samych danych: " + newEmployee);
        }
    }

    public void removeEmployee(int employeeNumber) {
        if (employeeNumber < 1 || employeeNumber > employees.size()) {
            logger.error("Próba usunięcia pracownika o niepoprawnym nurzerze porządkowym: " + employeeNumber);
            //   System.out.println("Lista nie zawiera pracownika o podanym numerze porządkowym.");
            return;
        }
        Employee employee = employees.remove(employeeNumber - 1);
        logger.info("Pracownik usuniety (" + employee + ")");
    }

    public void printEmployees() {
        System.out.println("--------------------");

        int index = 0;
        for (Employee employee : employees) {
            System.out.print(++index + " ");
            employee.print();
        }
        System.out.println("--------------------");
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public List<String> getAllCompanyEmployersSkills() {
        List<String> allSkills = new ArrayList<>();
        employees.forEach(employee -> {
                    var allEmployeesWithSkill = employee.getSkills();
                    for (String employeeSkill : allEmployeesWithSkill) {
                        if (allSkills.stream().noneMatch((skill -> skill.equals(employeeSkill)))) {
                            allSkills.add(employeeSkill);
                        }
                    }
                });
        return allSkills;
    }
}
