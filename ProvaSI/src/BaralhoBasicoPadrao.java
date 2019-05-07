
public class BaralhoBasicoPadrao {
	/* O ATRIBUTO BARALHO, SERÁ UM VETOR DE OBJETOS DO TIPO CARTA
	 * 
	 * VETORES, PODEM ARMAZENAR NÚMEROS INTEIROS, STRINGS OU ATÉ OBJETOS DE CLASSES CRIADAS POR NÓS
	 * 
	 * DIZER QUE UM VETOR ARMAZENA OBJETOS DO TIPO CARTA, SIGNIFICA QUE, ELE SÓ ACEITA GUARDAR OBJETOS
	 * DO TIPO CARTA, E QUANDO EU BUSCAR UM DETERMINADO VALOR DO VETOR ESPECIFICANDO O ÍNDICE, DESSA FORMA: BARALHO[0]
	 * ELE ME RETORNARÁ UM OBJETO DO TIPO CARTA, POIS CADA UM DOS SEUS ÍNDICES, POSSUI UM OBJETO DO TIPO CARTA
	 * */
	protected Carta[] baralho;
	
	/* CONSTRUTOR
	 * 
	 * RESOLVEMOS CRIAR UM CONSTRUTOR QUE NÃO NECESSITA DE PARÂMETROS
	 * ASSIM, QUANDO EU INSTANCIO UM OBJETO DO TIPO BaralhoBasicoPadrao, dessa forma:
	 * BaralhoBasicoPadrao baralho = new BaralhoBasicoPadrao()
	 * Ele irá executar todo esse código do construtor, criando um baralho completo
	 * com todos os naipes e seus respectivos valores possíveis e dois coringas
	 * 
	 * */
	BaralhoBasicoPadrao() {
		/* ANTES DE MAIS NADA, É NECESSÁRIO INICIALIZAR O ATRIBUTO BARALHO ESPECIFICANDO QUAL SERÁ O TAMANHO DO VETOR
		 * FAZEMOS UM new Carta PORQUE O ATRIBUTO BARALHO É DO TIPO CARTA E ABRIMOS CHAVES ESPECIFICANDO UM NÚMERO 
		 * PORQUE SE TRATA DE UM VETOR E É NECESSÁRIO ESPECIFICAR O TAMANHO QUE ELE TERÁ */
		baralho = new Carta[54];
		
		//AQUI JÁ CRIAMOS UM VETOR QUE ARMAZENA OS VALORES POSSÍVEIS PARA CADA NAIPE
		//E OUTRO VETOR QUE ARMAZENA AS INICIAIS DE CADA NAIPE POSSÍVEL (Copas, Ouros, Espada, Paus)
		String valor[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String naipe[] = {"C", "O", "E", "P"};
		
		//O INDICE DO BARALHO USAREMOS PARA CONTROLAR O ÍNDICE DO VETOR BARALHO, QUE DEVERÁ SER DE NO MÁXIMO 54-1 (53)
		//QUE DEFINIMOS NO INÍCIO
		int indiceBaralho = 0;
		
		/* AQUI COMEÇAREMOS A CRIAR AS CARTAS PARA CADA ÍNDICE DO NOSSO VETOR BARALHO
		 * A VARIÁVEL "i" IRÁ CONTROLAR O ÍNDICE DO VETOR NAIPE
		 * A VARIÁVEL "j" IRÁ CONTROLAR O ÍNDICE DO VETOR VALOR, QUE IRÁ RODAR 13 VEZES PARA CADA NAIPE
		 * */
		for(int i=0; i<4; i++) {
			
			for(int j=0; j<13; j++) {
				//O CONSTRUTOR DE CARTA, PARA CRIAR UMA CARTA, ESPERA QUE PASSEMOS O VALOR E O NAIPE DA CARTA
				this.baralho[indiceBaralho] = new Carta(valor[j], naipe[i]);
				indiceBaralho++;
			}
		}
		
		//FORA DO FOR, CRIAMOS AS DUAS CARTAS CORINGAS E ARMAZENAMOS NAS DUAS ÚLTIMAS POSIÇÕES DO BARALHO QUE SOBRARAM
		//O ÚLTIMO ÍNDICE É 53 PORQUE O ÍNDICE COMEÇA EM 0 
		baralho[52]= new Carta("W", ""); 
		baralho[53]= new Carta("W", ""); 

	}
	
	public Carta getCarta() {
		boolean nao_nulo = true;
		int i = 0;
		while(nao_nulo) {
			i = (int)(Math.random()*54);
			if(this.baralho[i] != null) {
				nao_nulo = false;
			}
		}
		Carta carta = this.baralho[i];
		baralho[i] = null;
		return carta;
	}
	
	public void putBackCarta(Carta carta) throws Exception {
		int inicioCopas = 0;
		int inicioOuros = 13;
		int inicioEspadas = 26;
		int inicioPaus = 39;
		int inicioCoringa = 52;
		int i;
		
		String valor[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		if(searchCarta(carta)) {
			throw new Exception("Carta já existe!");
		} else {
			for (i=0; i<13; i++){
				if (carta.getValor() == valor[i])
					break;
			}
			char naipe;
			
			if (carta.getValor() != "W")
				naipe = carta.getNaipe().charAt(0);
			else
				naipe = 'W';
			
			switch(naipe) {
				case 'C': 
					baralho[inicioCopas + i] = carta;
					break;
				case 'O':
					baralho[inicioOuros + i] = carta;
					break;
				case 'E':
					baralho[inicioPaus + i] = carta;
					break;
				case 'P':
					baralho[inicioPaus + i] = carta;
					break;
				case 'W':
					if(baralho[52] == null)
						baralho[52] = carta;
					else
						baralho[53] = carta;
			}
		}
		
	}
	
	public boolean searchCarta(Carta carta) {
		if(carta.getValor() != "W") {
			for(int i=0; i<54; i++) {
				if(carta.equals(baralho[i]))
					return true;
			}
		
		} else {
			if(baralho[52] != null && baralho[53] != null)
				return true;
		}			
		
		return false;
	}
	
	public String toString() {
		
		String baralho = "";
		
		for(int i=0; i<54; i++) {
			if(this.baralho[i] == null) {
				baralho = baralho + " NULL / ";
			}
			else
				baralho = baralho + "Valor: " + this.baralho[i].getValor() + " Naipe: " + this.baralho[i].getNaipe() + " / "; 
		}
		
		return baralho;
		
	}
	
	
}
