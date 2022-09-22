package application;

import companies.Company;
import entities.employees.*;

import java.util.List;

public class ApplicationInterface {
    public static void startApplication() {
        System.out.println("Start...");
        Company companyA = new Company("CompanyA");

        Human petr = new Human("Petr");
        Human nikolay = new Human("Nikolay");
        Human maria = new Human("Maria");
        Human rosa = new Human("Rosa");
        Human vera = new Human("Vera");
        Human mira = new Human("Mira");
        Human ivan = new Human("Ivan");
        Human lada = new Human("Lada");
        Human sasha = new Human("Sasha");
        Human oleg = new Human("Oleg");


        companyA.hireAllNewStaff(List.of((Employee) new Manager(petr), (Employee) new Tester(mira), (Employee) new Developer(ivan),
                (Employee) new TopManager(sasha), (Employee) new TopManager(oleg)));

        companyA.hireNewStaff(new Driver(nikolay));
        companyA.hireNewStaff(new Manager(rosa));
        companyA.hireNewStaff(new Cleaner(maria));
        companyA.hireNewStaff(new Director(vera));

        System.out.println();
        companyA.printAllEmployees();

        companyA.fireSelectedStaff(vera);

        System.out.println();
        companyA.printAllEmployees();

        companyA.hireNewStaff(new Director(vera));
        System.out.println();
        companyA.printAllEmployees();

//        companyA.fireSelectedStaff(lada);

        companyA.isHumanInternalEmployee(lada);
        companyA.isHumanInternalEmployee(sasha);

        System.out.println();

        companyA.createNewProject(companyA.findEmployeeByHuman(maria), "Project 0");
        companyA.createNewProject(companyA.findEmployeeByHuman(sasha), "Project 1");
        companyA.createNewProject(companyA.findEmployeeByHuman(sasha), "Project 2");
        companyA.createNewProject(companyA.findEmployeeByHuman(oleg), "Project 3");


        System.out.println();
        companyA.printAllActualDocuments();

        System.out.println();
        companyA.printAllActualProjects();

        companyA.addEmployeeToProject(companyA.findEmployeeByHuman(sasha), 2, companyA.findEmployeeByHuman(rosa));
        companyA.addEmployeeToProject(companyA.findEmployeeByHuman(oleg), 2, companyA.findEmployeeByHuman(ivan));

        System.out.println();
        companyA.printAllActualProjects();
    }

}
