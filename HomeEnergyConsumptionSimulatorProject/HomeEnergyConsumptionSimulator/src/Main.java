import Controllers.MainController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        MainController controller = new MainController();
        int option = 0;

        System.out.println("==Bem vindo ao sistema de Energia SAEC - Sistema Academico de Energia e Cálculo==");

        while(option != 9){
            System.out.println("Digite um número correspondente para acessar a função: \n" +
                    "1- Adicionar Residência\n" +
                    "2- Remover Residência\n" +
                    "3- Listar Residência\n" +
                    "4- Registrar Eletrodomésticos\n"+
                    "5- Remover Eletrodomésticos\n"+
                    "6- Listar Eletrodomésticos\n" +
                    "7- Calcular Custo de Luz Mensal\n" +
                    "8- INFO: Como funciona o sistema\n");
            option = scn.nextInt();

            switch(option){
                case 1:
                    //Implement
                    break;

                case 2:
                    //Implement
                    break;

                case 3:
                    break;

                case 4:
                    controller.electronicApp.Register(scn);
                    break;

                case 5:
                    controller.electronicApp.Remove(scn);
                    break;

                case 6:
                    controller.electronicApp.ListElectronicAppliances();
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    System.out.println("OBRIGADO POR UTILIZAR O SISTEMA");
                    break;

                default:
                    System.out.println("!!!OPÇÃO INVÁLIDA, POR FAVOR DIGITE ALGUM DA LISTA!!!");
                    break;
            }
        }
        scn.close();
    }
}