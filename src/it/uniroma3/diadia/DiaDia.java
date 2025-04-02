package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

/*può essere resa più coesa, si possono delegare alcune responsabilità ad altre classi sennò fa troppe cose ed è poco mantenibile o leggibile*/

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}
	

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	// si potrebbero separare i metodi dei comandi per una coesione maggiore (per ora meglio evitare) 
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()!=null) 
			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(); 
				return true;
			} else if (comandoDaEseguire.getNome().equals("vai"))
				this.vai(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("prendi"))
				this.prendi(comandoDaEseguire.getParametro());
			else if(comandoDaEseguire.getNome().equals("posa"))
				this.posa(comandoDaEseguire.getParametro());
			else if (comandoDaEseguire.getNome().equals("aiuto"))
				this.aiuto();
			else
				io.mostraMessaggio("Comando sconosciuto");
			if (this.partita.vinta()) {
				io.mostraMessaggio("Hai vinto!");
				return true;
			} else
				return false;   
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		StringBuilder messaggioAiuto = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			messaggioAiuto.append(elencoComandi[i]+" ");
		io.mostraMessaggio(messaggioAiuto.toString());
	}
	
	private void prendi(String nomeAttrezzo) {
		Stanza stanza = this.partita.getStanzaCorrente();
		Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			if(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				stanza.removeAttrezzo(attrezzo);
				io.mostraMessaggio("Hai inserito nella borsa l'attrezzo: "+attrezzo.getNome());
			}else {
				io.mostraMessaggio("Purtroppo non hai più spazio nella borsa!");
			}
		}else {
			io.mostraMessaggio("Purtroppo questo attrezzo non è presente nella stanza");
		}
		io.mostraMessaggio("La tua borsa al momento pesa:" + this.partita.getGiocatore().getBorsa().getPeso()+"Kg");
	}
	
	private void posa(String nomeAttrezzo) {
		Giocatore giocatore = this.partita.getGiocatore();
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {
			if(this.partita.getStanzaCorrente().addAttrezzo(attrezzo)) {
				giocatore.removeAttrezzo(nomeAttrezzo);
				io.mostraMessaggio("Hai posato correttamente l'attrezzo");
			}else {
				io.mostraMessaggio("Purtroppo la stanza è già piena");
			}
		}else {
			io.mostraMessaggio("Purtroppo non hai questo attrezzo");
		}
		io.mostraMessaggio("La tua borsa al momento pesa:" + this.partita.getGiocatore().getBorsa().getPeso()+ "Kg");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
			io.mostraMessaggio("La tua borsa al momento pesa: "+this.partita.getGiocatore().getBorsa().getPeso()+"Kg");
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("" +partita.getGiocatore().getCfu());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}