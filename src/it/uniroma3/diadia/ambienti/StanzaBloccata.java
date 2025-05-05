package it.uniroma3.diadia.ambienti;

class StanzaBloccata extends Stanza{
	String direzioneB;
	String attrezzoLibera;
	
	public StanzaBloccata(String nome, String attrezzoLibera, String direzioneB) {
        super(nome);
        this.attrezzoLibera = attrezzoLibera;
        this.direzioneB = direzioneB;
    }
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneB.equals(direzione) && !this.hasAttrezzo(attrezzoLibera)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata nella direzione: "+ direzioneB+"\nPrendi il " + attrezzoLibera + " e posalo nella stanza";

		if(!this.hasAttrezzo(attrezzoLibera))
			return bloccata;
		return super.getDescrizione();
	}

}
