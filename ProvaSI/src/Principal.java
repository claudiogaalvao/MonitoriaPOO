
public class Principal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BaralhoBasicoPadrao baralho = new BaralhoBasicoPadrao();
		
		System.out.println(baralho);
		Carta carta = null;
		boolean tru= true;
		
		while(tru) {
			carta = baralho.getCarta();
			if(carta.getValor() == "W") {
				tru = false;
			}
		}
		
		System.out.println(carta);
		
		System.out.println(baralho);
		
		baralho.putBackCarta(carta);
				
		System.out.println(baralho);

	}

}
