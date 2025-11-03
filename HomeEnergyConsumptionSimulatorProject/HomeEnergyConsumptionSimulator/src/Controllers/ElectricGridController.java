package Controllers;

import Models.ElectricGrid;

public class ElectricGridController {
    ElectricGrid electricGrid = new ElectricGrid();



    public void calculateResidenceCost(){
        System.out.println("Vamos calcular o custo da Residência: ");

        float sumEletronics = 1;
        //fazer um for passando o array passando por cada eletronico e colocando o tempo/horas que foi utilizado em média por dia

        float tax = electricGrid.getEletronicTax();
        int days = electricGrid.daysByMonth(2, true);

        float result = sumEletronics * days;
        float resultMonetary = result * tax;

        System.out.println("O custo de energia da residência total é de: "+result+" kW");
        System.out.println("O boleto gerado foi no valor de : "+resultMonetary+" reais");
    }
}
