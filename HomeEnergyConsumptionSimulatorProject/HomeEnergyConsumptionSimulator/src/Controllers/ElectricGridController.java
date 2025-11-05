package Controllers;

import Models.ElectricGrid;
import Models.Residence;

import java.util.Scanner;

public class ElectricGridController {
    ElectricGrid electricGrid = new ElectricGrid();

    public void calculateResidenceCost(Scanner scan, Residence residenceChoose, int monthChoose, boolean leapYear) {
        System.out.println("--Vamos calcular o custo da Residência: \n--A seguir a lista de eletrônicos que vai ser levada em consideração:");

        residenceChoose.getElectronicApplianceController().listElectronicAppliances();

        float sumEletronics = 0.0f;
        float tax = electricGrid.getEletronicTax();
        int days = electricGrid.daysByMonth(monthChoose, leapYear);

        var array = residenceChoose.getElectronicApplianceController();
        for(int i = 0; i<array.countElectronics();i++){
            System.out.println("-Eletrodoméstico: "+array.returnNameById(i));
            sumEletronics += returnTotalCostByDay(scan, array.returnCostById(i));
        }

        float result = sumEletronics * days;
        float resultMonetary = result * tax;

        System.out.println("O custo de energia da residência total é de: "+result+" kW");
        System.out.println("O boleto gerado foi no valor de : "+resultMonetary+" reais");
    }

    public float returnTotalCostByDay(Scanner scan, float costByHour){
        System.out.println("-Em média, quantas horas por dia foram utilizadas este aparelho ?");
        float hours = scan.nextFloat();
        return hours * costByHour;
    }
}
