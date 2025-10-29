package Controllers;

import java.util.Scanner;

//colocar aqui todos os controladores, para centralizar aqui os códigos em vez de declarar vários na main
public class MainController {
    public ElectricGridController electronicGrid = new ElectricGridController();
    public ElectronicApplianceController electronicApp = new ElectronicApplianceController();

    //todos os métodos que precisamos fazer uma chamada de outra classe também são declarados aqui

    public void StartCalculationEnergyCost(Scanner scan){
        System.out.println("DEFINA A RESIDÊNCIA QUE VOCÊ GOSTARIA DE CALCULAR: ");
        int residenceID = scan.nextInt();

        System.out.println("RESIDENCIA ESCOLHIDA: \n NOME: \n N° de Eletrodomésticos: \n" );

        System.out.println("--Digite o número do mês que você gostaria de calcular: ");
        int monthToCalc = scan.nextInt();
        if (monthToCalc == 2) {
            System.out.println("--É um ano bissexto? 1 para sim, 2 para não: ");
            boolean leapYear = (scan.nextInt() == 1);
        }

        System.out.println("--A taxa atual é de: \n +Gostara de alterar esta taxa? 1 para sim, 2 para não: ");
        boolean changeTax = (scan.nextInt() == 1);
        if (changeTax) {
            System.out.println("--Digite a nova taxa: ");
            float newTax = scan.nextFloat();
            electronicGrid.electricGrid.setEletronicTax(newTax);
        }

        //Ai vamos passar aqui embaixo, apenas a residence específica do array para ser alterada
        electronicGrid.calculateResidenceCost();
    }

    public void Info(){
        System.out.println("INFO:\nO sistema funciona cadastrando os eletrodomésticos que serão utilizados pelas residências." +
                " \nApós o registro das residências e a indicação dos aparelhos que cada uma possui, " +
                " o sistema permite informar o mês e o tempo de uso de cada eletrodoméstico," +
                " calculando automaticamente o consumo mensal de energia e o valor da conta do mês.");
    }
}
