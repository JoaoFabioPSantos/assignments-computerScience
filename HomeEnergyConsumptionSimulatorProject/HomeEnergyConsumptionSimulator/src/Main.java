import Controllers.MainController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MainController controller = new MainController();
        int option = 0;

        System.out.println("==Bem vindo ao sistema de Energia SAEC - Sistema Academico de Energia e Cálculo==");

        while(option != 10){
            System.out.println("\nDigite um número correspondente para acessar a função: \n" +
                    "1- Adicionar Residência\n" +
                    "2- Remover Residência\n" +
                    "3- Mostrar informação de Residência | Alterar Residência\n"+
                    "4- Listar Residências\n" +
                    "5- Registrar Eletrodomésticos\n"+
                    "6- Remover Eletrodomésticos\n"+
                    "7- Listar Eletrodomésticos\n" +
                    "8- Calcular Custo de Luz Mensal\n" +
                    "9- INFO: Como funciona o sistema\n" +
                    "10- SAIR DO SISTEMA\n");
            option = scan.nextInt();

            switch(option){
                case 1:
                    controller.residences.registerResidence(scan);
                    break;

                case 2:
                    controller.residences.removeResidence(scan);
                    break;

                case 3:
                    controller.residences.showResidenceInformation(scan);
                    break;

                case 4:
                    controller.residences.listResidences();
                    break;

                case 5:
                    controller.electronicApp.registerMain(scan);
                    break;

                case 6:
                    controller.electronicApp.removeMain(scan);
                    break;

                case 7:
                    controller.electronicApp.listElectronicAppliancesMain();
                    break;

                case 8:
                    controller.startCalculationEnergyCost(scan);
                    break;

                case 9:
                    controller.info();
                    System.out.print("Digite ok para continuar");
                    scan.next();
                    break;

                case 10:
                    System.out.println("OBRIGADO POR UTILIZAR O SISTEMA");
                    break;

                default:
                    System.out.println("!!!OPÇÃO INVÁLIDA, POR FAVOR DIGITE ALGUM DA LISTA!!!");
                    break;
            }
        }
        scan.close();
    }
}