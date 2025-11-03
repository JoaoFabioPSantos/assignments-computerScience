package Controllers;

import Models.ElectronicAppliance;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectronicApplianceController {
    ArrayList<ElectronicAppliance> electronics = new ArrayList<>();

    public void register(Scanner scan){
        System.out.println("==REGISTRANDO ELETRODOMÉSTICO==");
        System.out.println("-Digite o nome dele: ");
        String nameTemp = scan.next();
        System.out.println("-Digite o custo por hora em kW/h: ");
        float costByHourTemp = scan.nextFloat();

        boolean verifyer = electronics.add(new ElectronicAppliance(nameTemp, costByHourTemp));
        if(verifyer){
            System.out.println("-Eletrodoméstico adicionado com sucesso! \n-Digite ok para continuar");
            //Colocar o item que foi adicionado?
            scan.next();
        }else {
            System.out.println("Houve um problema de memória!");
        }
    }

    public void remove(Scanner scan){
        if (electronics.isEmpty()) {
            System.out.println("!!Não existem eletrodomésticos cadastrados!!");
        } else {
            System.out.println("==REMOVENDO ELETRODOMÉSTICO==");
            System.out.println("-Digite a ID do eletrodoméstico que deseja remover:");
            int idTemp = scan.nextInt();

            ElectronicAppliance toRemove = null;
            for (ElectronicAppliance e : electronics) {
                if (e.getId() == idTemp) {
                    toRemove = e;
                    break;
                }
            }

            if (toRemove != null) {
                System.out.println("SELECIONADO: \n Nome: "+toRemove.getName()+" || Custo: "+toRemove.getCostByHour());
                electronics.remove(toRemove);
                System.out.println("!!!ELETRODOMÉSTICO REMOVIDO!!!");
                System.out.println("Digite ok para prosseguir");
                scan.next();
            } else {
                System.out.println("ID não encontrado!");
            }
        }
    }

    public void listElectronicAppliances(){
        if (electronics.isEmpty()) {
            System.out.println("!!Não existem eletrodomésticos cadastrados!!");
        } else {
            for (ElectronicAppliance e : electronics) {
                System.out.println("-ID: "+e.getId()+" || NOME: "+e.getName()+" || CUSTO KW/H "+e.getCostByHour());
            }
        }
    }
}
