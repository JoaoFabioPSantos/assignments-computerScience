public class ClientBill {
	
		private char _gender;
		private int _beerQuantity;
		private int _softDrinkQuantity;
		private int _foodQuantity;
		
		private double _beerPrice = 5.00;
		private double _softDrinkPrice = 3.00;
		private double _foodPrice = 7.00;
		
		private double _enterBill;
		private double _consumedBill;
		private double _taxCouvertBill;
		private double _totalBill;
		
		
		public void set(char _gender, int _beerQuantity, int _softDrinkQuantity, int _foodQuantity) {
			this._gender = _gender;
			this._beerQuantity = _beerQuantity;
			this._softDrinkQuantity = _softDrinkQuantity;
			this._foodQuantity = _foodQuantity;
		}
		
		public void consumedBill() {
			_beerPrice *= _beerQuantity;
			_foodPrice *= _softDrinkQuantity;
			_softDrinkPrice *= _foodQuantity;
			
			_consumedBill = _beerPrice + _foodPrice + _softDrinkPrice;
			
			System.out.println("Consumo: R$"+_consumedBill);
		}
	
		public void couvertBill() {
			if(_consumedBill>=30.00) {
				System.out.println("Isento de Couvert");
				_taxCouvertBill = 0.00;
			}else {
				_taxCouvertBill = 4.00;
				System.out.println("Couvert: R$"+_taxCouvertBill);
			}			
		}
		
		public void ticketBill() {
			if(_gender=='M') {
				_enterBill = 10.00;
			}else if(_gender=='F') {
				_enterBill = 8.00;
			}
			
			System.out.println("Ingresso: R$"+_enterBill);
		}
		
		public void totalBill() {
			_totalBill = _enterBill+_taxCouvertBill+_consumedBill;
			System.out.println("Valor a pagar: R$"+_totalBill);
			
		}
}
