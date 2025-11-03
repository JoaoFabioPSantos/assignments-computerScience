package Controllers;

import Models.Residence;

import java.util.ArrayList;
import java.util.Scanner;

public class ResidenceController {
    ArrayList<Residence> residences = new ArrayList<>();

    public void registerResidence(Scanner scan){
        System.out.println("==REGISTRANDO RESIDÊNCIA==");
        System.out.print("-Digite o nome do registro: ");
        String nameTemp = scan.nextLine();

        System.out.println("-A residência possui eletrodomésticos? 1-sim / 2-não");
        int haveEletronics = scan.nextInt();
        if(haveEletronics == 1){

        }
        boolean verifyer = residences.add(new Residence(nameTemp));
        if(verifyer){
            System.out.println("-Residência cadastrada com sucesso\n-Digite ok para prosseguir");
            scan.next();
        }else {
            System.out.println("Houve um problema de memória!");
        }
    }

    public void removeResidence(Scanner scan){
        if (residences.isEmpty()) {
            System.out.println("!!Não existem residências cadastradas!!");
        } else {
            System.out.println("==REMOVENDO RESIDÊNCIA==");
            System.out.println("-Digite a ID da residência que deseja remover:");
            int idTemp = scan.nextInt();

            Residence toRemove = null;
            for (Residence e : residences) {
                if (e.getId() == idTemp) {
                    toRemove = e;
                    break;
                }
            }

            if (toRemove != null) {
                System.out.println("SELECIONADO: \n -Nome: "+toRemove.getName());
                residences.remove(toRemove);
                System.out.println("!!!RESIDÊNCIA REMOVIDA!!!");
                System.out.println("-Digite ok para prosseguir");
                scan.next();
            } else {
                System.out.println("!!ID não encontrado!!");
            }
        }
    }

    public void listResidences(){
        for (Residence e : residences) {
            System.out.println("-ID: "+e.getId()+"| Nome: "+e.getName());
        }
    }

    public void showResidenceInformation(Scanner scan){
        System.out.println("-Digite o id da Residência que você quer buscar as informações: ");
        int idResidence = scan.nextInt();

        Residence toFound = null;
        for (Residence e : residences) {
            if (e.getId() == idResidence) {
                toFound = e;
                break;
            }
        }

        if (toFound != null) {
            System.out.println("SELECIONADO: \n -Nome: "+toFound.getName());

            System.out.println("-Digite ok para prosseguir");
            scan.next();
        } else {
            System.out.println("!!ID não encontrado!!");
        }
    }

    public Residence getInformationResidence(int idResidence) {
        for (Residence e : residences) {
            if (e.getId() == idResidence) {
                return e;
            }
        }
        return null;
    }
}
