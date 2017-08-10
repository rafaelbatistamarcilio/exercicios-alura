package br.com.caelum.leilao.dominio;

public class Palindromo {

    public boolean ehPalindromo(String frase) {

        String fraseFiltrada = frase.toUpperCase().replace(" ", "").replace("-", "");
        String fraseInvertida = this.getFraseInvertida(fraseFiltrada);
        
        for(int i = 0; i < fraseFiltrada.length(); i++) {
            if(fraseFiltrada.charAt(i) != fraseInvertida.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    
    private String getFraseInvertida(String frase){
    	String fraseFiltrada = frase.toUpperCase().replace(" ", "").replace("-", "");
    	String fraseInvertida = "";
    	
    	char[] letras = fraseFiltrada.toCharArray();
    	
    	for(int i = letras.length -1 ; i>= 0; i-- ){
    		fraseInvertida += letras[i];
    	}
    	
    	return fraseInvertida;
    }
}
