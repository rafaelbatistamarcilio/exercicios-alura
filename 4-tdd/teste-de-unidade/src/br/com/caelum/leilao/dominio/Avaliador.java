package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.RuntimeErrorException;

class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double mediaDosLances;
	private List<Lance> maiores;

    public void avalia(Leilao leilao) {
    	
    	if(leilao.getLances().isEmpty()) throw new RuntimeException("N�o � poss�vel avaliar leil�es sem testes"); 
    		
    	double somaDosLances = 0;
    	
        for(Lance lance : leilao.getLances()) {
        	
            if(lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
            }
            
            if(lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
            }
            
            somaDosLances+=lance.getValor();
        }
        
        this.mediaDosLances = somaDosLances / leilao.getLances().size();
        pegaOsMaioresNo(leilao);
    }

    private void pegaOsMaioresNo(Leilao leilao) {
        this.maiores = new ArrayList<Lance>(leilao.getLances());
        
        Collections.sort(maiores, new Comparator<Lance>() {
            public int compare(Lance o1, Lance o2) {
                if(o1.getValor() < o2.getValor()) return 1;
                if(o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });
        
        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }
    
    public double getMediaDosLances() {    	
		return mediaDosLances;
	}
    
    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }
}
