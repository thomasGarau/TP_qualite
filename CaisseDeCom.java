public class CaisseDeCom extends CasePioche{

    public CaisseDeCom(String nom) {
        super(nom);
    }
    
    private void initDeck(){
        this.deck.add(new Carte("vous avez toucher un héritage vous percevez 200e",0,0,200));
        this.deck.add(new Carte("un controleur des impots à découvert votre fraude vous perdez 200e",0,0,-200));
        this.deck.add(new Carte("vous êtes deplacer à rue de la paix sans passer par la case départ",39,0,0));
        this.deck.add(new Carte("vous êtes déplacer de 4case",0,4,0));
    }

    public void action(Joueur J){
        
    }
}
