package co.bk.javaskills.support;

public class PrinterService {

    public PrinterService() {}

    public void updateConsoleToLowercase(Developer developer) {
        System.out.println("PrinterService.updateConsoleToLowercase() - " + developer.getName().toLowerCase() + " grade: " + developer.getSalary());
    }

    public void updateConsoleToUppercase(Developer developer) {
        System.out.println("PrinterService.updateConsoleToUppercase() - " + developer.getName().toUpperCase() + " grade: " + developer.getSalary());
    }
}
