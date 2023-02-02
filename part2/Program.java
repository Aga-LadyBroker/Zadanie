package pl.ladybroker.part2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileLogger fileInfoLogger = new FileLogger("company-info-log.txt", true, false);
        FileLogger fileErrorLogger = new FileLogger("company-error-log.txt", false, true);
        ConsoleLogger consoleLogger = new ConsoleLogger();

        MultiLogger multiLogger = new MultiLogger(new Logger[]{consoleLogger, fileInfoLogger, fileErrorLogger});
        Company company = new Company(multiLogger);

        company.add(new Developer("Janina", "Kowalski", 31, Sex.FEMALE, 4578, new String[]{"JAVA", "SQL", "HTML", "C#"}));
        company.add(new Manager("Julia", "Rutka", 15, Sex.FEMALE, 6894, new String[]{"JAVA", "SQL", "HTML"}, 5));
        company.add(new Developer("Angelika", "Miś", 45, Sex.FEMALE, 3489, new String[]{"JAVA", "SQL", "C#"}));
        company.add(new Developer("Anna", "Misiuda", 89, Sex.FEMALE, 4560, new String[]{"SQL", "HTML", "C#"}));
        company.add(new Developer("Agata", "Nowicka", 45, Sex.FEMALE, 5000, new String[]{"JAVA", "HTML", "C#"}));


        int operationNumber = 0;
        while (operationNumber != 9) {

            System.out.println(" Lista operacji :\n");
            System.out.println(" 1 - wypisz listę pracowników");
            System.out.println(" 2 - dodaj programistę");
            System.out.println(" 3 - dodaj kierownika");
            System.out.println(" 4 - usuń pracownika");
            System.out.println(" 5 - wypisz średnie zarobki ze względu na umiejętności");
            System.out.println(" 9 - zakończ program \n");

            System.out.print("Podaj numer operacji: ");
            operationNumber = scanner.nextInt();

            if (operationNumber == 1) {
                company.printEmployees();
            } else if (operationNumber == 2) {
                company.add(Developer.read());
            } else if (operationNumber == 3) {
                company.add(Manager.read());
            } else if (operationNumber == 4) {
                System.out.print("Podaj numer pracownika do usunięcia: ");
                int employeeNumber = scanner.nextInt();
                company.removeEmployee(employeeNumber);
            } else if (operationNumber == 5) {
                System.out.println("----------------- ");

                List<String> allCompanyEmployersSkills = company.getAllCompanyEmployersSkills();
                allCompanyEmployersSkills.stream().forEach(skill -> {
                    var allEmployeesWithSkills =
                            company.getEmployees().stream().filter(employee ->
                                    Arrays.asList(employee.getSkills()).contains(skill)).collect(Collectors.toList());
                    var employeesSalaryAverageForSkill = allEmployeesWithSkills.stream()
                            .mapToInt(Employee::getSalary).average().orElse(0);

                    int employeesSalaryAverageForSkillInt = (int) employeesSalaryAverageForSkill;
                    System.out.println(skill + " " + employeesSalaryAverageForSkillInt + "zł");
                });
                System.out.println("----------------- ");

            } else if (operationNumber != 9) {
                System.out.println("Operacja o podanym numerze nie istnieje! ");
            } else if (operationNumber == 9) {
                break;
            }
        }
    }
}

