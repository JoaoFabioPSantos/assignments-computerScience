import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);  
        
        TaxDeclaration declaration = new TaxDeclaration();
    
        System.out.println("Renda anual com salário médio: ");
        double salary = scn.nextDouble();

        System.out.println("Renda anual com prestação de serviço: ");
        double servicesIncome = scn.nextDouble();

        System.out.println("Renda anual com ganho de capital: ");
        double capitalGainIncome = scn.nextDouble();

        System.out.println("Gastos médicos: ");
        double medicalBill = scn.nextDouble();

		System.out.println("Gastos educacionais: ");
		double educationalBill = scn.nextDouble();
		
		declaration.get(salary, servicesIncome, capitalGainIncome, medicalBill, educationalBill);
		
		
		System.out.println("\n##RELATÓRIO DE IMPOSTO DE RENDA##");
		declaration.consolidatedIncome();
		declaration.deduction();
		declaration.resume();
		
		
		scn.close();
	}
}