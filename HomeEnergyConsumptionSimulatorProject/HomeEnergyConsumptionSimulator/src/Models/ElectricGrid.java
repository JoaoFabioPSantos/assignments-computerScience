package Models;

public class ElectricGrid {
    private static float eletronicTax = 0.1f;

    public float getEletronicTax(){
        return eletronicTax;
    }

    public void setEletronicTax(float eletronicTax){
        System.out.println("!!!OBS: Alterar esta taxa, altera todos os outros futuros cálculos, até houver novamente outra alteração.!!!");
        this.eletronicTax = eletronicTax;
    }

    public int daysByMonth(int monthPay, boolean leapYear) {
        int daysToReturn = switch (monthPay) {
            case 1, 3, 5, 7, 8, 10 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> leapYear ? 29 : 28;
            default -> 30;
        };
        return daysToReturn;
    }

}

