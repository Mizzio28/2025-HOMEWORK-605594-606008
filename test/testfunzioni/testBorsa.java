package testfunzioni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class testBorsa {
	private Borsa borsa;
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private Attrezzo attrezzo3;
    
    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        attrezzo1 = new Attrezzo("Spada", 3); 
        attrezzo2 = new Attrezzo("Scudo", 5); 
        attrezzo3 = new Attrezzo("Lanterna", 4);
    }
    
    @Test
    void testAddAttrezzo() {
    	assertTrue(borsa.addAttrezzo(attrezzo1));
    	assertTrue(borsa.hasAttrezzo("Spada"));
    }
    
    @Test
    void testAddAttrezzoLimitePeso() {
        assertTrue(borsa.addAttrezzo(attrezzo1)); 
        assertTrue(borsa.addAttrezzo(attrezzo2)); 
        assertFalse(borsa.addAttrezzo(attrezzo3)); 
        }

    @Test
    void testGetPeso() {
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        assertEquals(8, borsa.getPeso());
    }

    @Test
    void testRemoveAttrezzo() {
        borsa.addAttrezzo(attrezzo1);
        assertTrue(borsa.hasAttrezzo("Spada"));
        
        Attrezzo removed = borsa.removeAttrezzo("Spada");
        assertEquals(attrezzo1, removed);
        assertFalse(borsa.hasAttrezzo("Spada"));
    }

    @Test
    void testRemoveAttrezzoNonEsistente() {
        assertNull(borsa.removeAttrezzo("Elmo"));
    }
    

    @Test
    void testIsEmpty() {
        assertTrue(borsa.isEmpty());
        borsa.addAttrezzo(attrezzo1);
        assertFalse(borsa.isEmpty());
    }

    @Test
    void testToString() {
        borsa.addAttrezzo(attrezzo1);
        assertTrue(borsa.toString().contains("Spada"));
        borsa.removeAttrezzo("Spada");
        assertTrue(borsa.toString().contains("Borsa vuota"));
    }
    

}
