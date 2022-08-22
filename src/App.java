import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.JuridicPerson;
import entities.Person;
import entities.PhysicalPerson;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> list = new ArrayList<>();
        
        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual Income: ");
            Double annualIncome = sc.nextDouble();
            if (type == 'i') {
                System.out.print("Health Expenditures: ");
                Double healthSpending = sc.nextDouble();
                PhysicalPerson physicalPerson = new PhysicalPerson(name, annualIncome, healthSpending);
                list.add(physicalPerson);
            } else {
                System.out.print("Number of Employees: ");
                Integer employeeNumber = sc.nextInt();
                JuridicPerson juridicPerson = new JuridicPerson(name, annualIncome, employeeNumber);
                list.add(juridicPerson);
            }
        }

        System.out.println();
        double sum = 0.0;
        System.out.println("TAXES PAID: ");
        for (Person person : list) {
            double tax = person.tax();
            System.out.println(person.getName()+ ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));




        sc.close();
    }
}
