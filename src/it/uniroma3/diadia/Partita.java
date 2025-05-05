// andrebbe creata una classe labirinto che gestisce la topologia della mappa
// volendo si può inserire una classe giocatore nella quale inserire ad esempio la stanza corrente poichè è una proprietà del giocatore come ad esempio il suo inventario
package it.uniroma3.diadia;



import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
 	private int cfu;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.stanzaVincente = labirinto.getStanzaFinale();
		this.finita = false;
		this.giocatore = new Giocatore(CFU_INIZIALI);
	}
	
	/**
     * Restituisce la stanza vincente (finale).
     */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
     * Restituisce la stanza corrente.
     */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public boolean isVivo() {
		return this.giocatore.getCfu()>0;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
}
