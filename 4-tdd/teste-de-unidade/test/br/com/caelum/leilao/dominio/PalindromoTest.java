package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromoTest {

    @Test
    public void deveIdentificarSeNaoEhPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo("E preciso amar as pessoas como se nao houvesse amanha");
        assertFalse(resultado);
    }
    
    @Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Socorram-me subi no onibus em Marrocos");
        assertTrue(resultado);
    }

}
