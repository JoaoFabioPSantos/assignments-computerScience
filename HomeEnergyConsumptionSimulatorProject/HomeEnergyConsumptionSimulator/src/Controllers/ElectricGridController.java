package Controllers;

import Models.ElectricGrid;
import Models.Residence;

public class ElectricGridController {
    ElectricGrid electricGrid = new ElectricGrid();

    public void calculateResidenceCost(Residence residenceChoose, int monthChoose, boolean leapYear) {
        System.out.println("--Vamos calcular o custo da Residência: \n--A seguir a lista de eletrônicos que vai ser levada em consideração:");


        residenceChoose.getElectronicApplianceController().listElectronicAppliances();
        float sumEletronics = 0.0f;
        var array = residenceChoose.getElectronicApplianceController();
        for(int i = 0; i<array.countElectronics();i++){
            sumEletronics += array.returnCostById(i);
        }

        float tax = electricGrid.getEletronicTax();
        int days = electricGrid.daysByMonth(monthChoose, leapYear);

        float result = sumEletronics * days;
        float resultMonetary = result * tax;

        System.out.println("O custo de energia da residência total é de: "+result+" kW");
        System.out.println("O boleto gerado foi no valor de : "+resultMonetary+" reais");
    }
}
