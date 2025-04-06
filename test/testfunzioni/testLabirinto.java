package testfunzioni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testLabirinto {
	private Labirinto labirinto;
    private Stanza atrio;
    private Stanza aulaN11;
    private Stanza aulaN10;
    private Stanza laboratorio;
    private Stanza biblioteca;
    private Attrezzo lanterna;
    private Attrezzo osso;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
    }
    
    
    @Test
    void testStanzeCollegateCorrettamente() {
    	atrio = labirinto.getStanzaIniziale();  
        biblioteca = labirinto.getStanzaFinale();  
        aulaN11 = atrio.getStanzaAdiacente("est");
        aulaN10 = atrio.getStanzaAdiacente("sud");
        laboratorio = atrio.getStanzaAdiacente("ovest");        
        assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"));
        assertEquals(aulaN11, atrio.getStanzaAdiacente("est"));
        assertEquals(aulaN10, atrio.getStanzaAdiacente("sud"));
        assertEquals(laboratorio, atrio.getStanzaAdiacente("ovest"));
        assertEquals(laboratorio, aulaN11.getStanzaAdiacente("est"));
        assertEquals(atrio, aulaN11.getStanzaAdiacente("ovest"));
        assertEquals(atrio, aulaN10.getStanzaAdiacente("nord"));
        assertEquals(aulaN11, aulaN10.getStanzaAdiacente("est"));
        assertEquals(laboratorio, aulaN10.getStanzaAdiacente("ovest"));
        assertEquals(atrio, laboratorio.getStanzaAdiacente("est"));
        assertEquals(aulaN11, laboratorio.getStanzaAdiacente("ovest"));
        assertEquals(atrio, biblioteca.getStanzaAdiacente("sud"));
    }

    @Test
    void testAttrezziNelleStanze() {
    	aulaN10 = labirinto.getStanzaIniziale().getStanzaAdiacente("sud");
    	lanterna = new Attrezzo("lanterna", 3);
        osso = new Attrezzo("osso", 1);
         
        aulaN10.addAttrezzo(lanterna);
        atrio = labirinto.getStanzaIniziale();
        atrio.addAttrezzo(osso);

        assertTrue(aulaN10.hasAttrezzo("lanterna"));
        assertTrue(atrio.hasAttrezzo("osso"));
       
    }

    @Test
    void testGetterInizialeEFinale() {
    	atrio = labirinto.getStanzaIniziale();
    	biblioteca = labirinto.getStanzaFinale();
        assertEquals(atrio, labirinto.getStanzaIniziale());
        assertEquals(biblioteca, labirinto.getStanzaFinale());
    }

    @Test
    void testCollegamentiAdiacenti() {
    	atrio = labirinto.getStanzaIniziale();  
        aulaN11 = atrio.getStanzaAdiacente("est");
        atrio.impostaStanzaAdiacente("nord", aulaN11);
        assertEquals(aulaN11, atrio.getStanzaAdiacente("nord"));
    }

}
