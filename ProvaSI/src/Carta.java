
public class Carta {
	private String valor;
	private String naipe;	
	
	Carta(String valor, String naipe) {
		//AQUI DEVERIA CHECAR SE O NAIPE É VÁLIDO JÁ QUE O CURINGA É O ÚNICO QUE PODE
		//TER NAIPE VAZIO
		this.valor = valor;
		this.naipe = naipe;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNaipe() {
		return naipe;
	}

	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	public boolean equals(Carta carta) {
		//AQUI DEVERÁ CONTER AS OUTRAS VALIDAÇÕES DE UM MÉTODO GENÉRICO EQUALS
		
		if (carta == null)
			return false;
		
		if(this.getValor() != carta.getValor())
			return false;
		
		if(this.getNaipe() != carta.getNaipe())
			return false;
		
		return true;
	}
	
	public String toString() {
		return "Naipe: " + this.naipe + " Valor: " + this.valor;
	}
	
	

}
