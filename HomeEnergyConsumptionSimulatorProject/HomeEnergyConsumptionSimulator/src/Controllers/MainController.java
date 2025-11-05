package Controllers;

import java.util.Scanner;

public class MainController {
    public ElectricGridController electronicGrid = new ElectricGridController();
    public ElectronicApplianceController electronicApp = new ElectronicApplianceController();
    public ResidenceController residences = new ResidenceController();

    public void startCalculationEnergyCost(Scanner scan){
        System.out.println("DEFINA A RESIDÊNCIA QUE VOCÊ GOSTARIA DE CALCULAR: ");
        int residenceID = scan.nextInt();

        var residenceChoose = residences.getInformationResidence(residenceID);
        System.out.println("RESIDENCIA ESCOLHIDA: "+"\n -NOME: "+residenceChoose.getName()+"\n -N° de Eletrodomésticos: \n"+residenceChoose.getElectronicApplianceController().countElectronics());

        System.out.println("--Digite o número do mês que você gostaria de calcular: ");
        int monthToCalc = scan.nextInt();
        boolean leapYear = false;
        if (monthToCalc == 2) {
            System.out.println("--É um ano bissexto? 1 para sim, 2 para não: ");
            leapYear = (scan.nextInt() == 1);
        }

        System.out.println("--A taxa atual é de: "+electronicGrid.electricGrid.getEletronicTax()+"\n-Gostara de alterar esta taxa? 1 para sim, 2 para não: ");
        boolean changeTax = (scan.nextInt() == 1);
        if (changeTax) {
            System.out.println("--Digite a nova taxa: ");
            float newTax = scan.nextFloat();
            electronicGrid.electricGrid.setEletronicTax(newTax);
        }

        electronicGrid.calculateResidenceCost(scan, residenceChoose, monthToCalc, leapYear);
        System.out.println("--Digite ok para continuar");
        scan.next();
    }

    public void info(){
        System.out.println("INFO:\nO sistema funciona cadastrando os eletrodomésticos que serão utilizados pelas residências." +
                " \nApós o registro das residências e a indicação dos aparelhos que cada uma possui," +
                " o sistema permite informar o mês e\n o tempo de uso de cada eletrodoméstico," +
                " calculando automaticamente o consumo mensal de energia e o valor da conta do mês.");
    }
}
