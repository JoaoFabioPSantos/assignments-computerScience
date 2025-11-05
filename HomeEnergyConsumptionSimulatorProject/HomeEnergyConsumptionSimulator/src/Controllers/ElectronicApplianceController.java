package Controllers;

import Models.ElectronicAppliance;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectronicApplianceController {
    private static ArrayList<ElectronicAppliance> electronicsMain = new ArrayList<>();
    private ArrayList<ElectronicAppliance> electronics = new ArrayList<>();
    private static int registerControllerMain = 1;
    private static int nextIDList = 1;
    private int idApp;
    private boolean isMain;

    public ElectronicApplianceController(){
        idApp = nextIDList++;
        if(idApp == registerControllerMain)isMain = true;
    }

    public void registerMain(Scanner scan){
        System.out.println("==REGISTRANDO ELETRODOMÉSTICO==");
        System.out.println("-Digite o nome dele: ");
        String nameTemp = scan.next();
        System.out.println("-Digite o custo por hora em kW/h: ");
        float costByHourTemp = scan.nextFloat();

        boolean verifyer = electronicsMain.add(new ElectronicAppliance(nameTemp, costByHourTemp));
        if(verifyer){
            System.out.println("-Eletrodoméstico adicionado com sucesso! \n-Digite ok para continuar");
            scan.next();
        }else {
            System.out.println("Houve um problema de memória!");
        }
    }

    public void removeMain(Scanner scan){
        if (electronicsMain.isEmpty()) {
            System.out.println("!!Não existem eletrodomésticos cadastrados!!");
        } else {
            System.out.println("==REMOVENDO ELETRODOMÉSTICO==");
            System.out.println("-Digite a ID do eletrodoméstico que deseja remover:");
            int idTemp = scan.nextInt();

            ElectronicAppliance toRemove = null;
            for (ElectronicAppliance e : electronicsMain) {
                if (e.getId() == idTemp) {
                    toRemove = e;
                    break;
                }
            }

            if (toRemove != null) {
                System.out.println("SELECIONADO: \n Nome: "+toRemove.getName()+" || Custo: "+toRemove.getCostByHour());
                electronicsMain.remove(toRemove);
                System.out.println("!!!ELETRODOMÉSTICO REMOVIDO!!!");
                System.out.println("Digite ok para prosseguir");
                scan.next();
            } else {
                System.out.println("ID não encontrado!");
            }
        }
    }

    public void listElectronicAppliancesMain(){
        if (electronicsMain.isEmpty()) {
            System.out.println("!!Não existem eletrodomésticos cadastrados!!");
        } else {
            for (ElectronicAppliance e : electronicsMain) {
                System.out.println("-ID: "+e.getId()+" || NOME: "+e.getName()+" || CUSTO KW/H "+e.getCostByHour());
            }
        }
    }

    public boolean register(Scanner scan){
        if(electronicsMain.isEmpty()){
            System.out.println("!!Cadastre algum eletrodoméstico para adicionar a alguma Residência!!");
            return true;
        }
        System.out.println("==REGISTRANDO ELETRODOMÉSTICO NA RESIDÊNCIA==\n--Quantos eletrodomésticos gostaria de adicionar?");
        int quantityAdd =  scan.nextInt();

        if(quantityAdd==0){
            System.out.println("--Então tudo bem");
            return true;
        }

        System.out.println("\n--Esta é a lista atual de eletrodomésticos cadastrada no sistema:");
        listElectronicAppliancesMain();

        for(int i=0; i<quantityAdd; i++){
            System.out.println("\n--Digite o ID do eletrodoméstico que gostaria de adicionar na residência: ");
            int idToAdd = scan.nextInt();

            for(ElectronicAppliance e : electronicsMain){
                if(idToAdd == e.getId()){
                    electronics.add(e);
                    System.out.println("--Eletrodoméstico adicionado: "+e.getName());
                }
            }
        }
        return true;
    }

    public void remove(Scanner scan){
        if (electronics.isEmpty()) {
            System.out.println("!!Não existem eletrodomésticos cadastrados!!");
        } else {
            System.out.println("==REMOVENDO ELETRODOMÉSTICO==");
            listElectronicAppliances();
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
            System.out.println("!!Não existem eletrodomésticos cadastrados nesta residência!!");
        } else {
            for (ElectronicAppliance e : electronics) {
                System.out.println("-ID: "+e.getId()+" || NOME: "+e.getName()+" || CUSTO KW/H "+e.getCostByHour());
            }
        }
    }

    public int countElectronics(){
        return electronics.size();
    }

    public float returnCostById(int id) {
        for (ElectronicAppliance e : electronics) {
            if (e.getId() == id) {
                return e.getCostByHour();
            }
        }

        return 0.0f;
    }
}
