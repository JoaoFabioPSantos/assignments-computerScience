public class TaxDeclaration{
    
	private double salaryTax;
	private double servicesTax;
	private double capitalGainTax;
    
	private double maxTax;
	private double maxDeduction;
    
	private double salary;
	private double servicesIncome;
	private double capitalGainIncome;
    
	private double medicalBill;
	private double educationalBill;
    
	public void get(double salary, double servicesIncome, double capitalGainIncome, double medicalBill, double educationalBill){
    	this.salary = salary;
    	this.servicesIncome = servicesIncome;
    	this.capitalGainIncome = capitalGainIncome;
    	this.medicalBill = medicalBill;
    	this.educationalBill = educationalBill;
	}
    
	private double salaryTax( ){
    	if(salary<3000.00){
        	salaryTax = 0.00;
       	 
    	}else if(salary<5000.00){
        	salaryTax = 0.1;
   	 
    	}else if(salary>=5000.00){
        	salaryTax = 0.2;
       	 
    	}
    	return salaryTax*salary;
	}
    
	private double servicesTax(){
    	if(servicesIncome!=0.00){
        	servicesTax = 0.15;
       	 
    	}else{
        	servicesTax = 0.00;
       	 
    	}
    	return servicesTax*servicesIncome;
	}
    
	private double capitalGainTax(){
    	if(capitalGainIncome!=0.00){
        	capitalGainTax = 0.20;
       	 
    	}else{
        	capitalGainTax = 0.00;
       	 
    	}
   	 
    	return capitalGainTax*capitalGainIncome;
	}
    
	private double getMaxTax(){
    	maxTax = (salaryTax()+servicesTax()+capitalGainTax());
    	return maxTax;
	}
    
	private double maxDeduction(){
    	maxDeduction = (salaryTax()+servicesTax()+capitalGainTax())*0.3);
   	 
    	if((medicalBill+educationalBill)>maxDeduction{
        	return maxDeduction;
    	}else{
        	return medicalBill+educationalBill;
    	}
   	 
	}
    
	public void consolidatedIncome(){
    	System.out.println("\n*CONSOLIDADO DE RENDA: ");
    	System.out.println("Imposto sobre salário: "+salaryTax());
    	System.out.println("Imposto sobre serviços: "+servicesTax());
    	System.out.println("Imposto sobre serviço de capital: "+capitalGainTax());
	}
    
	public void deduction(){
    	System.out.println("\n*DEDUÇÕES: ");
    	System.out.println("Máximo dedutível: "+maxDeduction());
    	System.out.println("Gastos dedutíveis: "+(medicalBill+educationalBill));
	}
    
	public void resume(){
    	System.out.println("\n*RESUMO: ");
    	System.out.println("Imposto Bruto Total: "+getMaxTax());
    	System.out.println("Abatimento: "+maxDeduction());
    	System.out.println("Imposto devido: "+(getMaxTax()-maxDeduction()));
	}
    
}
